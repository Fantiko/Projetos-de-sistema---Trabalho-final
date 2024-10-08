package sistemalogin.trabalhofinal.mensagem;

public class Msg {
    private String mensagem;

    private boolean lida;

    private int id;

    private int idUsuario;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

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

    public Msg(String mensagem, int idUsuario) {
        this.mensagem = mensagem;
        this.lida = false;
        this.idUsuario = idUsuario;
    }

    public Msg(String mensagem, Boolean lida, int id, int idUsuario) {
        this.mensagem = mensagem;
        this.lida = lida;
        this.id = id;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
