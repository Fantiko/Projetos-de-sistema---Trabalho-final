package sistemalogin.trabalhofinal.model;

public class User extends Estado{
    private boolean aprovado;

    public User(Usuario usuario) {
        super(usuario);
        this.aprovado = false;
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
