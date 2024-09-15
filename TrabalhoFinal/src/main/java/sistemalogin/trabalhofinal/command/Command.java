package sistemalogin.trabalhofinal.command;

import sistemalogin.trabalhofinal.dao.UsuarioDAO;
import sistemalogin.trabalhofinal.model.Usuario;
import sistemalogin.trabalhofinal.presenter.Sistema;

public abstract class Command
{
    protected Sistema sistema;

    public Command(Sistema sistema)
    {
        this.sistema = sistema;
    }

    public abstract void executar(Usuario usuario) throws Exception;
}
