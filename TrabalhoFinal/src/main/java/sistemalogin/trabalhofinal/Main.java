/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sistemalogin.trabalhofinal;

import sistemalogin.trabalhofinal.dao.MensagemDAOSQLite;
import sistemalogin.trabalhofinal.mensagem.Msg;
import sistemalogin.trabalhofinal.presenter.Sistema;
import sistemalogin.trabalhofinal.view.TelaPrincipal;
import sistemalogin.trabalhofinal.dao.UsuarioDAOSQLite;
import sistemalogin.trabalhofinal.model.Usuario;

/**
 *
 * @author kaios
 * @author Gustavo Provete de Andrade
 */
public class Main {

    public static void main(String[] args)
    {

        Msg msg = new Msg("ola mundo", 1, 3);
        MensagemDAOSQLite dao = new MensagemDAOSQLite();

        dao.cadastrarMensagens(msg);






    }
}
