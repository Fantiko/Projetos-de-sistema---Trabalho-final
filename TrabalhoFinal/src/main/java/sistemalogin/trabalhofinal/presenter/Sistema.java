package sistemalogin.trabalhofinal.presenter;

import com.pss.senha.validacao.ValidadorSenha;
import org.example.Logger.Operacao;
import org.slf4j.LoggerFactory;
import sistemalogin.trabalhofinal.command.*;
import sistemalogin.trabalhofinal.dao.DB;
import sistemalogin.trabalhofinal.dao.MensagemDAOSQLite;
import sistemalogin.trabalhofinal.dao.UsuarioDAO;
import sistemalogin.trabalhofinal.dao.UsuarioDAOSQLite;
import sistemalogin.trabalhofinal.mensagem.Msg;
import sistemalogin.trabalhofinal.model.Usuario;
import sistemalogin.trabalhofinal.view.Observer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import sistemalogin.trabalhofinal.view.TelaPrincipal;
import org.example.Logger.Logger;
import org.example.Logger.JSONLogger;
import org.example.Logger.CSVLogger;
import org.example.Logger.Operacao;

import javax.swing.*;

import sistemalogin.trabalhofinal.view.*;


public class Sistema 
{
    private ArrayList<Observer> telas;
    private Logger logger;
    private Usuario usuarioLogado;
    private UsuarioDAO usuarioDAO;
    private MensagemDAOSQLite MSGDAO;
    public TelaPrincipal telaPrincipal;

    private final AutorizarUsuarioCommand autorizarUsuarioCommand;
    private final CriarUsuarioCommand criarUsuarioCommand;
    private final DeletarUsuarioCommand deletarUsuarioCommand;
    private final RejeitarUsuarioCommand rejeitarUsuarioCommand;

    public Sistema()
    {
        DB.main();
        telas = new ArrayList<Observer>();
        telaPrincipal = new TelaPrincipal(this);
        logger = new JSONLogger();
        usuarioDAO = new UsuarioDAOSQLite();
        MSGDAO = new MensagemDAOSQLite();
        addTela(telaPrincipal);

        autorizarUsuarioCommand = new AutorizarUsuarioCommand(this);
        criarUsuarioCommand = new CriarUsuarioCommand(this);
        deletarUsuarioCommand = new DeletarUsuarioCommand(this);
        rejeitarUsuarioCommand = new RejeitarUsuarioCommand(this);
    }
    

    public List<Observer> getTelas() {
        return telas;
    }
    public void addTela(Observer tela){
        telas.add(tela);
    }


    private void notificarTelas() {
        for (Observer observer : telas) {
            observer.atualizar();
        }
    }
    
    public void adicionarObserver(Observer observer) {
        telas.add(observer);
    }

    public void setLogger(Logger logger)
    {
        this.logger = logger;
    }

    public void log(Operacao operacao, Usuario usuarioAfetado)
    {
        logger.log(operacao, usuarioAfetado.getNome(), LocalDateTime.now(), this.usuarioLogado.getNome());
    }

    public void logError(String errorMensagem, Operacao operacao, Usuario usuarioAfetado)
    {
        logger.logErro(errorMensagem, operacao, usuarioAfetado.getNome(), LocalDateTime.now(), this.usuarioLogado.getNome());
    }

    public void logar(String nome, String senha, TelaLogin telalogin)
    {
        Usuario usuarioLogado = null;

        try
        {
            usuarioLogado = usuarioDAO.logarUsuario(nome, senha);
            
        } catch (Exception e)
        {
            if(usuarioLogado == null)
            {
                JOptionPane.showMessageDialog(telaPrincipal,
                        "Login e/ou senha incorretos.",
                        "Erro de Login",
                        JOptionPane.ERROR_MESSAGE);
                return;
                
            }
            
 
        }

        if(usuarioLogado.isAprovado())
        {
            this.usuarioLogado = usuarioLogado;
            telaPrincipal.setNomeUsuario(usuarioLogado.getNome());
            telaPrincipal.setTipoUsuario(usuarioLogado.getNomeEstado());
            telalogin.setVisible(false);
            telaPrincipal.abreOpcaoAdm();
            notificarTelas();
            
        } else
        {
            JOptionPane.showMessageDialog(telaPrincipal,
                        "Usuario não aprovado para login.",
                        "Erro de Login",
                        JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public boolean isSenhaValida(String senha)
    {
        boolean isSenhaValida = true;

        ValidadorSenha validadorSenha = new ValidadorSenha();

        ArrayList<String> resultadoValidacao = (ArrayList<String>) validadorSenha.validar(senha);

        if(!resultadoValidacao.isEmpty())
        {
            isSenhaValida = false;
        }

        for(String s : resultadoValidacao)
        {
            JOptionPane.showMessageDialog(telaPrincipal
                    , s
                    , "Erro de senha"
                    , JOptionPane.ERROR_MESSAGE);
        }

        return isSenhaValida;
    }

    public void cadastrarUsuario(Usuario usuario)
    {
        try
        {
            this.criarUsuarioCommand.executar(usuario);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void abreTela(EnviarMensagem Enviarmensagem){
        if(usuarioLogado.getNomeEstado().equalsIgnoreCase("adm")){
            Enviarmensagem.setVisible(true);
        }
        
    }
    
    public void abreMenu(JMenu abreOpcao)
    {
        if (usuarioLogado.getNomeEstado().equalsIgnoreCase("adm"))
        {
            abreOpcao.setVisible(true);
        }
    }

    public ArrayList<Usuario> pegarUsuariosNaoAprovados()
    {
        try
        {
            return usuarioDAO.listarUsuariosNaoAprovados();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Usuario> pegarUsuarios(){
    
        try
        {
            return usuarioDAO.listarUsuarios();
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return null;
    }

    public ArrayList<Msg> ListarMSGUsuario(){
        try
        {
            return MSGDAO.listarMensagensUsuario(this.usuarioLogado.getId());
        } catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public void cadastrarMSGUsuario(Msg msg){

        Usuario usuario = null;
        try
        {
            usuario = usuarioDAO.consultarUsuario(msg.getIdUsuario());
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            MSGDAO.cadastrarMensagens(msg);
            log(Operacao.ENVIO_NOTIFICACAO, usuario);
        } catch(Exception e){
            logError("Erro: Não foi possivel cadastrar uma nova mensagem", Operacao.ENVIO_NOTIFICACAO, usuario);
            e.printStackTrace();
        }
    }

    public Msg consultarMSG(int id) throws Exception
    {
        try
        {
            return MSGDAO.consultarMensagen(id);
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Erro: Não foi possivel ler a mensagem");
        }
    }

    public void alterarSenha(String senhaNova, String senhaAtual){
        if(usuarioLogado.getSenha().equals(senhaAtual)){
            
            if (this.isSenhaValida(senhaNova)) {
                usuarioLogado.setSenha(senhaNova);

                try
                {
                    usuarioDAO.alterarUsuario(usuarioLogado.getId(), usuarioLogado);
                    log(Operacao.ALTERACAO, usuarioLogado);
                } catch (Exception e)
                {
                    logError(e.getMessage(), Operacao.ALTERACAO, usuarioLogado);
                    e.printStackTrace();
                    return;
                }

                log(Operacao.ALTERACAO_SENHA, usuarioLogado);
                
                JOptionPane.showMessageDialog(telaPrincipal,
                        "Senha alterada.",
                        "Senha Alterada",
                        JOptionPane.INFORMATION_MESSAGE);
            }
                
        }
        else{
            JOptionPane.showMessageDialog(telaPrincipal,
                    "Senha atual incorreta.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            logError("Erro: Senha atual incorreta", Operacao.ALTERACAO_SENHA, usuarioLogado);
        }       
    }

    public void autorizarUsuario(Usuario usuario)
    {
        try
        {
            this.autorizarUsuarioCommand.executar(usuario);
            notificarTelas();
            log(Operacao.AUTORIZACAO_USUARIO, usuario);
        } catch (Exception e)
        {
            logError("Erro: Não foi possivel autorizar o usuario", Operacao.AUTORIZACAO_USUARIO, usuario);
            e.printStackTrace();
        }
    }

    public void rejeitarUsuario(Usuario usuario)
    {
        try
        {
            this.rejeitarUsuarioCommand.executar(usuario);
            notificarTelas();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public UsuarioDAO getUsuarioDAO()
    {
        return usuarioDAO;
    }

    public Usuario getUsuarioLogado()
    {
        return this.usuarioLogado;
    }
    
    public void deletaUsuario(int id){
        Usuario usuario = null;
        try
        {
             usuario = usuarioDAO.consultarUsuario(id);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            usuarioDAO.excluirUsuario(id);
            notificarTelas();
            log(Operacao.EXCLUSAO, usuario);
        } catch (Exception e)
        {
            logError(e.getMessage(), Operacao.EXCLUSAO, usuario);
            e.printStackTrace();
        }
    }
    
    
}
