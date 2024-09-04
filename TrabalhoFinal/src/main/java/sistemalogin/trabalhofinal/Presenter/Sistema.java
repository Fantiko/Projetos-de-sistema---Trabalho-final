package sistemalogin.trabalhofinal.Presenter;

import sistemalogin.trabalhofinal.View.Observer;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Observer> telas;

    public Sistema() {
        this.telas = new ArrayList<>();
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

}
