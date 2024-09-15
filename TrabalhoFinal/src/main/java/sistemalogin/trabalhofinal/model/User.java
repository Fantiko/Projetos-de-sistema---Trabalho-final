package sistemalogin.trabalhofinal.model;

public class User extends Estado{
    private boolean aprovado;

    public User(Usuario usuario, Boolean aprovado) {
        super(usuario);
        this.aprovado = aprovado;
    }
    @Override
    public boolean isAprovado() {
        return aprovado;
    }
    @Override
    public void setAprovado() {
        this.aprovado = true;
    }

}
