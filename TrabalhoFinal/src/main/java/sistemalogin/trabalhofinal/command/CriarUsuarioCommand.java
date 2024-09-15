package sistemalogin.trabalhofinal.command;

import sistemalogin.trabalhofinal.dao.UsuarioDAO;
import sistemalogin.trabalhofinal.model.Usuario;
import sistemalogin.trabalhofinal.presenter.Sistema;

public class CriarUsuarioCommand extends Command
{
    public CriarUsuarioCommand(Sistema sistema)
    {
        super(sistema);
    }

    @Override
    public void executar(Usuario usuario) throws Exception
    {
        if(!sistema.isSenhaValida(usuario.getSenha()))
        {
            return;
        }

        try
        {
            boolean isPrimeiroUsuario = sistema.getUsuarioDAO().isEmpty();

            sistema.getUsuarioDAO().cadastrarUsuario(usuario);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
