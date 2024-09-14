package sistemalogin.trabalhofinal.Presenter;

import sistemalogin.trabalhofinal.View.Observer;

import java.util.ArrayList;
import java.util.List;
import sistemalogin.trabalhofinal.View.TelaCadastroUsuario;
import sistemalogin.trabalhofinal.View.TelaPrincipal;

public class Sistema 
{
    private ArrayList<Observer> telas;
    public TelaPrincipal telaPrincipal;

    public Sistema() 
    {
        telas = new ArrayList<Observer>();
        telaPrincipal = new TelaPrincipal(this);
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

}
