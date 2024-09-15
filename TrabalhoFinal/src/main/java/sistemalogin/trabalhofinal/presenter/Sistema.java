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

import javax.swing.*;

import sistemalogin.trabalhofinal.view.*;


public class Sistema 
{
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Sistema.class);
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
            notificarTelas();
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
        try
        {
            MSGDAO.cadastrarMensagens(msg);
        } catch(Exception e){
            e.printStackTrace();
        }
    }



    
    public void alterarSenha(String senhaNova, String senhaAtual){
        if(usuarioLogado.getSenha().equals(senhaAtual)){
            
            if (this.isSenhaValida(senhaNova)) {
                usuarioLogado.setSenha(senhaNova);
                usuarioDAO.alterarUsuario(usuarioLogado.getId(), usuarioLogado);
                
                JOptionPane.showMessageDialog(telaPrincipal,
                        "Senha alterada.",
                        "Senha Alterada",
                        JOptionPane.ERROR_MESSAGE);
            }
                
        }
        else{
                JOptionPane.showMessageDialog(telaPrincipal,
                        "Senha atual incorreta.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);  
        
        }       
    }

    public void autorizarUsuario(Usuario usuario)
    {
        try
        {
            this.autorizarUsuarioCommand.executar(usuario);
            notificarTelas();
        } catch (Exception e)
        {
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
       
        usuarioDAO.excluirUsuario(id);
        notificarTelas();
    }
}
