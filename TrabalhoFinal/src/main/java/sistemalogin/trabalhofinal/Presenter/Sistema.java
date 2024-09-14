package sistemalogin.trabalhofinal.Presenter;

import com.pss.senha.validacao.ValidadorSenha;
import org.example.Logger.Operacao;
import org.slf4j.LoggerFactory;
import sistemalogin.trabalhofinal.Dao.DAO;
import sistemalogin.trabalhofinal.Model.Usuario;
import sistemalogin.trabalhofinal.View.Observer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import sistemalogin.trabalhofinal.View.TelaCadastroUsuario;
import sistemalogin.trabalhofinal.View.TelaPrincipal;
import org.example.Logger.Logger;
import org.example.Logger.CSVLogger;
import org.example.Logger.JSONLogger;

import javax.swing.*;


public class Sistema 
{
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Sistema.class);
    private ArrayList<Observer> telas;
    private Logger logger;
    private Usuario usuarioLogado;
    private DAO dao;
    public TelaPrincipal telaPrincipal;

    public Sistema() 
    {
        telas = new ArrayList<Observer>();
        telaPrincipal = new TelaPrincipal(this);
        logger = new JSONLogger();
        dao = new DAO();
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

    public void logar(String nome, String senha)
    {
        Usuario usuarioLogado = null;

        try
        {
            usuarioLogado = dao.logarUsuario(nome, senha);
        } catch (Exception e)
        {
            if(usuarioLogado == null)
            {

                JOptionPane.showMessageDialog(telaPrincipal,
                        "Login e/ou senha incorretos.",
                        "Erro de Login",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        if(usuarioLogado != null)
        {
            this.usuarioLogado = usuarioLogado;
        }
    }
}
