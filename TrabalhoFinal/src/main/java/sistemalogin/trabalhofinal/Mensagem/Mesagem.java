package sistemalogin.trabalhofinal.Mensagem;

public class Mesagem {
    private String mensagem;

    private boolean lida;

    public boolean isLida() {
        return lida;
    }

    public void setLida(boolean lida) {
        this.lida = true;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Mesagem(String mensagem) {
        this.mensagem = mensagem;
        this.lida = false;
    }
}
