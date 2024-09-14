package sistemalogin.trabalhofinal.dao;

import sistemalogin.trabalhofinal.mensagem.Msg;
import sistemalogin.trabalhofinal.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MensagemDAOSQLite implements MensagemDAO{
    private static PreparedStatement preparedStatement= null;
    private static ResultSet resultSet = null;

    private static final String CADASTRAR_MENSAGENS = " INSERT INTO Mensagens "
            + " (id, usuarioId, mensagem, Lida) "
            + " VALUES (NULL, ?, ?) ";


    private static final String CONSULTAR_MENSAGEM = " SELECT * FROM Mesagens "
            + " WHERE id = ? ";

    private static final String IS_EMPTY = "SELECT EXISTS (SELECT 1 FROM Mensagens)";

    private static final String EXCLUIR_MENSAGEM = " DELETE FROM Mensagens "
            + " WHERE id = ? ";

    private static final String LISTAR_MENSAGENS = " SELECT * FROM Mensagens "
            + " WHERE 1 = 1 ";

    private static final String LISTAR_MENSAGENS_USER = " SELECT * FROM Mensagens " +
            " WHERE idUsuario = ? ";


    public MensagemDAOSQLite() {
    }


    public ArrayList<Msg> listarMensagensUsuario(int idUsuario) throws Exception
    {
        Connection connection = Conexao.getInstance().abrirConexao();
        ArrayList<Msg> msgs = new ArrayList<>();

        String query = LISTAR_MENSAGENS_USER;

        try
        {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idUsuario);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                Msg msg = new Msg(
                        resultSet.getString("mensagem"),
                        resultSet.getBoolean("Lida"),
                        resultSet.getInt("id"),
                        resultSet.getInt("usuarioId")
                );
                msgs.add(msg);
            }


        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            fecharConexao();
        }
        if (msgs.size() < 0)
        {
            //TRATAR QUE NAO ENCONTROU O USUARIO
            throw new Exception("NAO HA CLIENTES");
        }
        return msgs;
    }


    public ArrayList<Msg> listarMensagens() throws Exception
    {
        Connection connection = Conexao.getInstance().abrirConexao();
        ArrayList<Msg> msgs = new ArrayList<>();

        String query = LISTAR_MENSAGENS;

        try
        {
            preparedStatement = connection.prepareStatement(query);


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                Msg msg = new Msg(
                        resultSet.getString("mensagem"),
                        resultSet.getBoolean("Lida"),
                        resultSet.getInt("id"),
                        resultSet.getInt("usuarioId")
                );
                msgs.add(msg);
            }


        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            fecharConexao();
        }
        if (msgs.size() < 0)
        {
            //TRATAR QUE NAO ENCONTROU O USUARIO
            throw new Exception("NAO HA CLIENTES");
        }
        return msgs;
    }

    @Override
    public void excluirMensagem(int id)
    {
        Connection connection = Conexao.getInstance().abrirConexao();

        String query = EXCLUIR_MENSAGEM;

        try
        {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;

            preparedStatement.setInt(i++, id);

            preparedStatement.execute();


        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            fecharConexao();
        }


    }
    @Override
    public Msg consultarMensagen(int id) throws Exception
    {
        Connection connection = Conexao.getInstance().abrirConexao();
        Msg msg = null;

        String query = CONSULTAR_MENSAGEM;

        try
        {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            preparedStatement.setInt(i++, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                msg = new Msg(
                        resultSet.getString("mensagem"),
                        resultSet.getBoolean("Lida"),
                        resultSet.getInt("id"),
                        resultSet.getInt("usuarioId")
                );
            }


        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            fecharConexao();
        }
        if (msg == null)
        {
            throw new NoSuchElementException("Mensagem com ID " + id + " não encontrado");
        }
        return msg;
    }

    @Override
    public void cadastrarMensagens(Msg msg)
    {
        Connection connection = Conexao.getInstance().abrirConexao();
        String query = CADASTRAR_MENSAGENS;

        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int i = 1;

            preparedStatement.setInt(i++, msg.getIdUsuario());
            preparedStatement.setString(i++, msg.getMensagem());
            preparedStatement.setBoolean(i++, msg.isLida());
            preparedStatement.executeUpdate();  // Executa a atualização no banco

        } catch (SQLException e)
        {
            e.printStackTrace();
            try
            {
                if (connection != null)
                {
                    connection.rollback();
                }
            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        } finally
        {
            // Fecha o PreparedStatement e Connection
            fecharConexao();
        }
    }





    @Override
    public boolean isEmpty() throws Exception
    {
        Connection connection = Conexao.getInstance().abrirConexao();

        String query = IS_EMPTY;

        try
        {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            boolean isEmpty = !resultSet.getBoolean(1);

            fecharConexao();
            return isEmpty;

        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new Exception("Erro ao verificar se a tabela está vazia.");
        } finally
        {
            fecharConexao();
        }
    }



    @Override
    public void fecharConexao() {
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
