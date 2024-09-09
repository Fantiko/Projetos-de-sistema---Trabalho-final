package sistemalogin.trabalhofinal.Dao;

import sistemalogin.trabalhofinal.Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {


    //TODO mano ajustar esses clientes para o usuario 



    private static PreparedStatement preparedStatement= null;
    private static ResultSet resultSet = null;
    private static String DRIVER = "org.sqlite.JDBC";
    private static String BD = "jdbc:sqlite:LoginDB.db";

    private static String CADASTRAR_CLIENTE = " INSERT INTO CLIENTE "
            + " (ID, NOME)"
            + " VALUES (NULL, ?)";

    private static String CONSULTAR_CLIENTE = " SELECT * FROM CLIENTE "
            + " WHERE ID = ? ";


    private static String ALTERAR_CLIENTE = " UPDATE CLIENTE "
            + " NOME = ? "
            + " WHERE ID = ? ";


    private static String EXCLUIR_CLIENTE = " DELETE FROM CLIENTE "
            + " WHERE ID = ? ";

    private static String LISTAR_CLIENTES = " SELECT * FROM CLIENTE "
            + " WHERE 1 = 1 ";

    private static String CONSULTAR_USUARIO = " SELECT USUARIO, SENHA "
            + " FROM USUARIO "
            + " WHERE USUARIO = ? "
            + " SND SENHA = ? ";

    public DAO() {

    }

    /*public void cadastrarCliente(Usuario usuario){
        Connection connection = Conexao.getInstance().abrirConexao();

        String query = CADASTRAR_CLIENTE;

        preparedStatement = connection.prepareStatement(query);
        int i = 0;
        preparedStatement.setString();



    }*/



}
