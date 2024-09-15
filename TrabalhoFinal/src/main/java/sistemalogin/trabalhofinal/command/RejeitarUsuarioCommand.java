package sistemalogin.trabalhofinal.command;

import sistemalogin.trabalhofinal.model.Usuario;
import sistemalogin.trabalhofinal.presenter.Sistema;

public class RejeitarUsuarioCommand extends Command
{
    public RejeitarUsuarioCommand(Sistema sistema)
    {
        super(sistema);
    }

    @Override
    public void executar(Usuario usuario) throws Exception
    {
        if(sistema.getUsuarioLogado().getNomeEstado().equals("adm"))
        {
            sistema.getUsuarioDAO().excluirUsuario(usuario.getId());
        } else
        {
            throw new Exception("Permissão negada.");
        }
    }
}
