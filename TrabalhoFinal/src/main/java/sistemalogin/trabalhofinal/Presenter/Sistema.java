package sistemalogin.trabalhofinal.Presenter;

import sistemalogin.trabalhofinal.View.Observer;

import java.util.ArrayList;
import java.util.List;
import sistemalogin.trabalhofinal.View.TelaCadastroUsuario;

public class Sistema {
    private List<Observer> telas;
    
    public TelaCadastroUsuario telacadastrousuario;

    public Sistema() {
        
        this.telas = new ArrayList<>();
        this.telacadastrousuario = new TelaCadastroUsuario();
        adicionarObserver(this.telacadastrousuario);
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
