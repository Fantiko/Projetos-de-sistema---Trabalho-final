package sistemalogin.trabalhofinal.model;

import sistemalogin.trabalhofinal.command.Command;

public abstract class Estado {

    protected Usuario usuario;
    private boolean aprovado;

    public Estado(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNomeEstado() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    public boolean isAprovado() {
        throw new RuntimeException("Não é possível ver aprovacao " + getNomeEstado());
    }
    public void setAprovado() {
        throw new RuntimeException("Não é possível setar aprocvacao " + getNomeEstado());
    }

}
