/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sistemalogin.trabalhofinal;

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

    public static void main(String[] args) {
        
        Sistema sistema = new Sistema();
        // Criando o objeto da classe Usuario com os dados do usuário
        Usuario usuario = new Usuario(
                100,
                "gustas",            // Nome
                "2223",        // Senha
                2,               // Notificações lidas
                5,               // Notificações recebidas
                "user",           // Estado (nomeEstado)
                false               // Aprovado
        );

        // Criando o objeto da classe que manipula o banco de dados
        UsuarioDAOSQLite usuarioDAOSQLite = new UsuarioDAOSQLite();

        try {
            // Cadastrando o usuário no banco de dados
            usuarioDAOSQLite.cadastrarUsuario(usuario);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar o usuário.");
        }


        TelaPrincipal telaPrincipal = new TelaPrincipal(new Sistema());
        telaPrincipal.setVisible(true);
    }
}
