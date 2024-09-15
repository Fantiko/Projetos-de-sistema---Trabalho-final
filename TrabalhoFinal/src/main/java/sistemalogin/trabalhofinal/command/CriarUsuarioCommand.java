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
        if(sistema.getUsuarioLogado().getNomeEstado().equals("adm"))
        {
            if(!sistema.isSenhaValida(usuario.getSenha()))
            {
                return;
            }

            try
            {
                boolean isPrimeiroUsuario = sistema.getUsuarioDAO().isEmpty();
                //boolean isPrimeiroUsuario = false;

                sistema.getUsuarioDAO().cadastrarUsuario(usuario);

            } catch (Exception e)
            {
                e.printStackTrace();
            }
        } else
        {
            throw new Exception("Permissão negada.");
        }
    }
}
