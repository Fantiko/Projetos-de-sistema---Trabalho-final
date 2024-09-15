package sistemalogin.trabalhofinal.model;

public class Adm extends Estado{
    private final boolean aprovado;
    public Adm(Usuario usuario) {
        super(usuario);
        aprovado = true;
    }

    @Override
    public boolean isAprovado() {
        return aprovado;
    }
}
