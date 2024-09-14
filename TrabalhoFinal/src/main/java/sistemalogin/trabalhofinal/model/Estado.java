package sistemalogin.trabalhofinal.model;

public abstract class Estado {

    protected Usuario usuario;

    private boolean aprovado;

    public Estado(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNomeEstado() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    public void criarUsuario(){
        throw new RuntimeException("Não é possível criar usuario " + getNomeEstado());
    }

    public void aprovarUsuario(){
        throw new RuntimeException("Não é possível aprovar usuario " + getNomeEstado());
    }

    public void deletarUsuario(){
        throw new RuntimeException("Não é possível deletar usuario " + getNomeEstado());
    }

    public boolean isAprovado() {
        throw new RuntimeException("Não é possível ver aprovacao " + getNomeEstado());
    }
    public void setAprovado() {
        throw new RuntimeException("Não é possível setar aprocvacao " + getNomeEstado());
    }


}
