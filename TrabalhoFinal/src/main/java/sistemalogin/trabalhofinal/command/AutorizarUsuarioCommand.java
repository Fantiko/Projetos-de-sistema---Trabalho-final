package sistemalogin.trabalhofinal.command;

import sistemalogin.trabalhofinal.model.Usuario;
import sistemalogin.trabalhofinal.presenter.Sistema;

public class AutorizarUsuarioCommand extends Command
{

    public AutorizarUsuarioCommand(Sistema sistema)
    {
        super(sistema);
    }

    @Override
    public void executar(Usuario usuario) throws Exception
    {
        if(sistema.getUsuarioLogado().getNomeEstado().equals("adm"))
        {
            sistema.getUsuarioDAO().autorizarUsuario(usuario.getId());
        } else
        {
            throw new Exception("Permissão negada.");
        }
    }
}
