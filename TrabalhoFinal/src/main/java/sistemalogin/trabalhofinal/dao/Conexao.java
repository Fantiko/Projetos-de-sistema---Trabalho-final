package sistemalogin.trabalhofinal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Conexao instancia;
    private static String DRIVER = "org.sqlite.JDBC";
    private static String BD = "jdbc:sqlite:TrabalhoFinal/src/main/java/sistemalogin/trabalhofinal/resources/LoginDB";
    //private static String BD = "jdbc:sqlite:src/main/java/sistemalogin/trabalhofinal/resources/LoginDB";
    private static Connection conexao;


    private Conexao(){

    }

    public static Conexao getInstance(){
        if (instancia == null){
            instancia = new Conexao();
        }
        return instancia;
    }

    public Connection abrirConexao(){
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(BD);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao conectar com o banco de dados" + e.getMessage());
        }
        return conexao;
    }

    public void fecharConexao(){
        try {
            if (conexao != null && conexao.isClosed()){
                conexao.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexao com o banco de dados:" + e.getMessage());
        }finally {
            conexao = null;
        }
    }


}
