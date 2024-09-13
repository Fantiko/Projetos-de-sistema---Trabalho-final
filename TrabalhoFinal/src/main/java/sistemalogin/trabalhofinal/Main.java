/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sistemalogin.trabalhofinal;

import sistemalogin.trabalhofinal.Dao.DAO;
import sistemalogin.trabalhofinal.Model.Usuario;

/**
 *
 * @author kaios
 */
public class Main {

    public static void main(String[] args) {
        // Criando o objeto da classe Usuario com os dados do usuário
        Usuario usuario = new Usuario(
                4,
                "Ruanzinho",            // Nome
                "2223",        // Senha
                2,               // Notificações lidas
                5,               // Notificações recebidas
                "user",           // Estado (nomeEstado)
                false               // Aprovado
        );

        // Criando o objeto da classe que manipula o banco de dados
        DAO dao = new DAO();

        try {
            // Cadastrando o usuário no banco de dados
            dao.cadastrarUsuario(usuario);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar o usuário.");
        }

    }
}
