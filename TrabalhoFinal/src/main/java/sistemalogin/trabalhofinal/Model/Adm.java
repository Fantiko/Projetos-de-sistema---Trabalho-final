package sistemalogin.trabalhofinal.Model;

public class Adm extends Estado{
    private boolean aprovado;
    public Adm(Usuario usuario) {
        super(usuario);
        aprovado = true;
    }



    @Override
    public void criarUsuario(){

    }
    @Override
    public void aprovarUsuario(){

    }
    @Override
    public void deletarUsuario(){

    }


    @Override
    public boolean isAprovado() {
        return aprovado;
    }
}
