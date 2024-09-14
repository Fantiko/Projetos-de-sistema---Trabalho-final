package sistemalogin.trabalhofinal.dao;

import sistemalogin.trabalhofinal.model.Usuario;

import java.util.ArrayList;

public interface UsuarioDAO
{
    void cadastrarUsuario(Usuario usuario);
    Usuario consultarUsuario(int id) throws Exception;
    void alterarUsuario(int id, Usuario usuario);
    void excluirUsuario(int id);
    ArrayList<Usuario> listarUsuarios() throws Exception;
    ArrayList<Usuario> listarUsuariosNaoAprovados() throws Exception;
    Usuario logarUsuario(String nomeUsuario, String senhaUsuario) throws Exception;
    public boolean isEmpty() throws Exception;
    void fecharConexao();
    void autorizarUsuario(int id);
}