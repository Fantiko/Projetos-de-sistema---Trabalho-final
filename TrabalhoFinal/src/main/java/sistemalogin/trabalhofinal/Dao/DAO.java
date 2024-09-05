package sistemalogin.trabalhofinal.Dao;

import sistemalogin.trabalhofinal.Model.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class DAO {


    //TODO mano ajustar esses clientes para o usuario



    private static PreparedStatement preparedStatement= null;
    private static ResultSet resultSet = null;
    private static String DRIVER = "org.sqlite.JDBC";
    private static String BD = "jdbc:sqlite:LoginDB.db";

    private static final String CADASTRAR_CLIENTE = " INSERT INTO CLIENTE "
            + " (ID, NOME, SENHA, LIDAS, RECEBIDAS, TIPO, APROVADO)"
            + " VALUES (NULL, ?, ?, ?, ?, ?, ?)";

    private static final String CONSULTAR_CLIENTE = " SELECT * FROM CLIENTE "
            + " WHERE ID = ? ";


    private static final String ALTERAR_CLIENTE = " UPDATE CLIENTE SET"
            + " NOME = ? "
            + " SENHA = ? "
            + " LIDAS = ? "
            + " RECEBIDAS = ? "
            + " TIPO = ? "
            + " APROVADO = ? "
            + " WHERE ID = ? ";


    private static final String EXCLUIR_CLIENTE = " DELETE FROM CLIENTE "
            + " WHERE ID = ? ";

    private static final String LISTAR_CLIENTES = " SELECT * FROM CLIENTE "
            + " WHERE 1 = 1 ";

    private static final String CONSULTAR_USUARIO = " SELECT USUARIO, SENHA "
            + " FROM USUARIO "
            + " WHERE USUARIO = ? "
            + " AND SENHA = ? ";

    public DAO() {

    }

    public void cadastrarUsuario(Usuario usuario){
        Connection connection = Conexao.getInstance().abrirConexao();

        String query = CADASTRAR_CLIENTE;

        try {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            // NOME, SENHA, LIDAS, RECEBIDAS, TIPO, APROVADO
            preparedStatement.setString(i++, usuario.getNome());
            preparedStatement.setString(i++, usuario.getSenha());
            preparedStatement.setString(i++, usuario.getNotificacoesLidas());
            preparedStatement.setString(i++, usuario.getNotificacoesRecebidas());
            preparedStatement.setString(i++, usuario.getNomeEstado());
            preparedStatement.setString(i++, usuario.isAprovado());

            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            fecharConexao();
        }


    }

    public Usuario consultarUsuario(String id) throws Exception {
        Connection connection = Conexao.getInstance().abrirConexao();
        Usuario usuario = null;

        String query = CONSULTAR_CLIENTE;

        try {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            preparedStatement.setString(i++, id);

            resultSet = preparedStatement.executeQuery();

            While(resultSet.next()){
                //TODO COLOCA O CONSTRUTOR DO USUARIO DIREITO NISSO
                usuario = new Usuario();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            fecharConexao();
        }
        if (usuario == null){
            //TRATAR QUE NAO ENCONTROU O USUARIO
            throw new Exception("encontrou nao o amigo");
        }
        return usuario;
    }

    public void alterarUsuario(String id, Usuario usuario){
        Connection connection = Conexao.getInstance().abrirConexao();

        String query = ALTERAR_CLIENTE;

        try {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            preparedStatement.setString(i++, usuario.getNome());
            preparedStatement.setString(i++, id);

            preparedStatement.execute();
            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            fecharConexao();
        }


    }

    public void excluirUsuario(String id){
        Connection connection = Conexao.getInstance().abrirConexao();

        String query = EXCLUIR_CLIENTE;

        try {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;

            preparedStatement.setString(i++, id);

            preparedStatement.execute();
            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            fecharConexao();
        }


    }

    public ArrayList<Usuario> listarUsuarios() throws Exception {
        Connection connection = Conexao.getInstance().abrirConexao();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        String query = LISTAR_CLIENTES;

        try {
            preparedStatement = connection.prepareStatement(query);






            resultSet = preparedStatement.executeQuery();

            While(resultSet.next()){
                //TODO COLOCA O CONSTRUTOR DO USUARIO DIREITO NISSO
                usuarios.add(new Usuario());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            fecharConexao();
        }
        if (usuarios.size() < 0 ){
            //TRATAR QUE NAO ENCONTROU O USUARIO
            throw new Exception("NAO HA CLIENTES");
        }
        return usuarios;
    }

    public Usuario logarUsuario(String nomeUsuario, String senhaUsuario) throws Exception {
        Connection connection = Conexao.getInstance().abrirConexao();
        Usuario usuario = null;

        String query = CONSULTAR_USUARIO;

        try {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            preparedStatement.setString(i++, nomeUsuario);
            preparedStatement.setString(i++, senhaUsuario);

            resultSet = preparedStatement.executeQuery();

            While(resultSet.next()){
                //TO-DO COLOCA O CONSTRUTOR DO USUARIO DIREITO NISSO
                usuario = new Usuario();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            fecharConexao();
        }
        if (usuario == null){
            //TRATAR QUE NAO ENCONTROU O USUARIO
            throw new Exception("encontrou nao o amigo");
        }
        return usuario;
    }




    private void fecharConexao() {
            try {
                if (resultSet!=null) {
                    resultSet.close();
                }
                if (preparedStatement != null){
                    preparedStatement.close();
                }
                Conexao.getInstance().fecharConexao();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }


}
