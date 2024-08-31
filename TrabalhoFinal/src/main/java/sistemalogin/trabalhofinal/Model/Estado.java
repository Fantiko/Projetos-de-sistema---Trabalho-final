package sistemalogin.trabalhofinal.Model;

public abstract class Estado {

    protected Usuario usuario;

    public Estado(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNomeEstado() {
        return this.getClass().getSimpleName().toLowerCase();
    }



}
