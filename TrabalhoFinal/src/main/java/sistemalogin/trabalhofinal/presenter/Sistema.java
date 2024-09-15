package sistemalogin.trabalhofinal.presenter;

import com.pss.senha.validacao.ValidadorSenha;
import org.example.Logger.Operacao;
import org.slf4j.LoggerFactory;
import sistemalogin.trabalhofinal.dao.DB;
import sistemalogin.trabalhofinal.dao.UsuarioDAO;
import sistemalogin.trabalhofinal.dao.UsuarioDAOSQLite;
import sistemalogin.trabalhofinal.model.Usuario;
import sistemalogin.trabalhofinal.view.Observer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import sistemalogin.trabalhofinal.view.TelaPrincipal;
import org.example.Logger.Logger;
import org.example.Logger.JSONLogger;

import javax.swing.*;
import javax.swing.JLabel;
import sistemalogin.trabalhofinal.view.*;


public class Sistema 
{
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Sistema.class);
    private ArrayList<Observer> telas;
    private Logger logger;
    private Usuario usuarioLogado;
    private UsuarioDAO usuarioDAO;
    public TelaPrincipal telaPrincipal;

    public Sistema() 
    {
        DB.main();
        telas = new ArrayList<Observer>();
        telaPrincipal = new TelaPrincipal(this);
        logger = new JSONLogger();
        usuarioDAO = new UsuarioDAOSQLite();
        addTela(telaPrincipal);
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

    public void cadastrarUsuario(String nome, String senha)
    {
        if(!isSenhaValida(senha))
        {
            return;
        }

        try
        {
            boolean isPrimeiroUsuario = usuarioDAO.isEmpty();
            //boolean isPrimeiroUsuario = false;

            Usuario novoUsuario = new Usuario(nome, senha, isPrimeiroUsuario);
            usuarioDAO.cadastrarUsuario(novoUsuario);
            this.notificarTelas();
            
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

    public void autorizarUsuario(int id)
    {
        usuarioDAO.autorizarUsuario(id);
        notificarTelas();
    }

    public void rejeitarUsuario(int id)
    {
        usuarioDAO.excluirUsuario(id);
        notificarTelas();
    }
    
    public void deletaUsuario(int id){
       
        usuarioDAO.excluirUsuario(id);
        notificarTelas();
    }
}
