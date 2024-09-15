package sistemalogin.trabalhofinal.dao;

import sistemalogin.trabalhofinal.model.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class UsuarioDAOSQLite implements UsuarioDAO
{

    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    private static final String CADASTRAR_CLIENTE = " INSERT INTO Usuario "
            + " (id, nome, senha, notificacoesLidas, notificacoesRecebidas, tipo, aprovado, criacaoData)"
            + " VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";

    private static final String CONSULTAR_CLIENTE = " SELECT * FROM Usuario "
            + " WHERE id = ? ";


    private static final String ALTERAR_CLIENTE = "UPDATE Usuario SET"
            + " nome = ?,"
            + " senha = ?,"
            + " notificacoesLidas = ?,"
            + " notificacoesRecebidas = ?,"
            + " tipo = ?,"
            + " aprovado = ?"
            + " WHERE id = ?";


    private static final String EXCLUIR_CLIENTE = " DELETE FROM Usuario "
            + " WHERE id = ? ";

    private static final String LISTAR_CLIENTES = " SELECT * FROM Usuario "
            + " WHERE tipo = 'user' ";

    private static final String CONSULTAR_USUARIO = " SELECT * "
            + " FROM USUARIO "
            + " WHERE nome = ? "
            + " AND senha = ? ";

    private static final String IS_EMPTY = "SELECT EXISTS (SELECT 1 FROM Usuario)";

    private static final String LISTAR_CLIENTES_NAO_APROVADOS = "SELECT *"
            + " FROM Usuario"
            + " WHERE aprovado = false";

    private static final String AUTORIZAR_USUARIO = "UPDATE Usuario SET" +
            " aprovado = true" +
            " WHERE id = ?";

    public UsuarioDAOSQLite()
    {

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
    public void cadastrarUsuario(Usuario usuario)
    {
        Connection connection = Conexao.getInstance().abrirConexao();
        String query = CADASTRAR_CLIENTE;

        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int i = 1;
            // NOME, SENHA, LIDAS, RECEBIDAS, TIPO, APROVADO
            preparedStatement.setString(i++, usuario.getNome());
            preparedStatement.setString(i++, usuario.getSenha());
            preparedStatement.setDouble(i++, usuario.getNotificacoesLidas());
            preparedStatement.setDouble(i++, usuario.getNotificacoesRecebidas());
            preparedStatement.setString(i++, usuario.getNomeEstado());
            preparedStatement.setBoolean(i++, usuario.isAprovado());
            preparedStatement.setString(i++,usuario.getDataCadastro());
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
    public Usuario consultarUsuario(int id) throws Exception
    {
        Connection connection = Conexao.getInstance().abrirConexao();
        Usuario usuario = null;

        String query = CONSULTAR_CLIENTE;

        try
        {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            preparedStatement.setInt(i++, id);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                //TODO COLOCA O CONSTRUTOR DO USUARIO DIREITO NISSO
                usuario = new Usuario(id,
                        resultSet.getString("nome"),
                        resultSet.getString("senha"),
                        resultSet.getDouble("notificacoesLidas"),
                        resultSet.getDouble("notificacoesRecebidas"),
                        resultSet.getString("tipo"),
                        resultSet.getBoolean("aprovado"),
                        LocalDate.parse(resultSet.getString("criacaoData"))
                );
            }


        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            fecharConexao();
        }
        if (usuario == null)
        {
            //TRATAR QUE NAO ENCONTROU O USUARIO
            throw new NoSuchElementException("Usuário com ID " + id + " não encontrado");
        }
        return usuario;
    }

    @Override
    public void alterarUsuario(int id, Usuario usuario) throws Exception
    {
        Connection connection = Conexao.getInstance().abrirConexao();

        String query = ALTERAR_CLIENTE;

        try
        {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            preparedStatement.setString(i++, usuario.getNome());
            preparedStatement.setString(i++, usuario.getSenha());
            preparedStatement.setDouble(i++, usuario.getNotificacoesLidas());
            preparedStatement.setDouble(i++, usuario.getNotificacoesRecebidas());
            preparedStatement.setString(i++, usuario.getNomeEstado());
            preparedStatement.setBoolean(i++, usuario.isAprovado());
            preparedStatement.setInt(i++, id);

            preparedStatement.execute();


        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new Exception("Erro: Não foi possivel alterar o usuário");
        } finally
        {
            fecharConexao();
        }


    }

    @Override
    public void excluirUsuario(int id) throws Exception
    {
        Connection connection = Conexao.getInstance().abrirConexao();

        String query = EXCLUIR_CLIENTE;

        try
        {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;

            preparedStatement.setInt(i++, id);

            preparedStatement.executeUpdate();


        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new Exception("Erro: Não foi possivel excluir o usuario");
        } finally
        {
            fecharConexao();
        }


    }

    @Override
    public ArrayList<Usuario> listarUsuarios() throws Exception
    {
        Connection connection = Conexao.getInstance().abrirConexao();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        String query = LISTAR_CLIENTES;

        try
        {
            preparedStatement = connection.prepareStatement(query);


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                Usuario usuario = new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),                // nome
                        resultSet.getString("senha"),               // senha
                        resultSet.getDouble("notificacoesLidas"),               // notificações lidas
                        resultSet.getDouble("notificacoesRecebidas"),           // notificações recebidas
                        resultSet.getString("tipo"),              // nomeEstado
                        resultSet.getBoolean("aprovado"),
                        LocalDate.parse(resultSet.getString("criacaoData"))
                );
                usuarios.add(usuario);
            }


        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            fecharConexao();
        }
        if (usuarios.size() < 0)
        {
            //TRATAR QUE NAO ENCONTROU O USUARIO
            throw new Exception("NAO HA CLIENTES");
        }
        return usuarios;
    }

    @Override
    public ArrayList<Usuario> listarUsuariosNaoAprovados() throws Exception
    {
        Connection connection = Conexao.getInstance().abrirConexao();
        ArrayList<Usuario> usuariosNaoAprovados = new ArrayList<>();

        String query = LISTAR_CLIENTES_NAO_APROVADOS;

        try
        {
            preparedStatement = connection.prepareStatement(query);


            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                Usuario usuario = new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("senha"),
                        resultSet.getDouble("notificacoesLidas"),
                        resultSet.getDouble("notificacoesRecebidas"),
                        resultSet.getString("tipo"),
                        resultSet.getBoolean("aprovado"),
                        LocalDate.parse(resultSet.getString("criacaoData"))
                );
                usuariosNaoAprovados.add(usuario);
            }


        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            fecharConexao();
        }
        if (usuariosNaoAprovados.size() < 0)
        {
            //TRATAR QUE NAO ENCONTROU O USUARIO
            throw new Exception("NAO HA CLIENTES");
        }
        return usuariosNaoAprovados;
    }

    @Override
    public Usuario logarUsuario(String nomeUsuario, String senhaUsuario) throws Exception
    {
        Connection connection = Conexao.getInstance().abrirConexao();
        Usuario usuario = null;

        String query = CONSULTAR_USUARIO;

        try
        {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            preparedStatement.setString(i++, nomeUsuario);
            preparedStatement.setString(i++, senhaUsuario);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                usuario = new Usuario(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),                // nome
                        resultSet.getString("senha"),               // senha
                        resultSet.getDouble("notificacoesLidas"),               // notificações lidas
                        resultSet.getDouble("notificacoesRecebidas"),           // notificações recebidas
                        resultSet.getString("tipo"),              // nomeEstado
                        resultSet.getBoolean("aprovado"),
                        LocalDate.parse(resultSet.getString("criacaoData"))
                );
                
            }


        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            fecharConexao();
        }
       
        
        if (usuario == null)
        {
            //TRATAR QUE NAO ENCONTROU O USUARIO
            throw new Exception("encontrou nao o amigo");
        }
        return usuario;
    }


    @Override
    public void fecharConexao()
    {
        try
        {
            if (resultSet != null)
            {
                resultSet.close();
            }
            if (preparedStatement != null)
            {
                preparedStatement.close();
            }
            Conexao.getInstance().fecharConexao();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    public void autorizarUsuario(int id)
    {
        Connection connection = Conexao.getInstance().abrirConexao();

        String query = AUTORIZAR_USUARIO;

        try
        {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            preparedStatement.setString(i++, String.valueOf(id));
            preparedStatement.executeUpdate();


        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            fecharConexao();
        }
    }
}
