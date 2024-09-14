package sistemalogin.trabalhofinal.dao;

import sistemalogin.trabalhofinal.model.Usuario;

import java.util.ArrayList;

public interface UsuarioDAO
{
    void cadastrarUsuario(Usuario usuario);
    Usuario consultarUsuario(int id) throws Exception;
    void alterarUsuario(String id, Usuario usuario);
    void excluirUsuario(String id);
    ArrayList<Usuario> listarUsuarios() throws Exception;
    Usuario logarUsuario(String nomeUsuario, String senhaUsuario) throws Exception;
    void fecharConexao();
}