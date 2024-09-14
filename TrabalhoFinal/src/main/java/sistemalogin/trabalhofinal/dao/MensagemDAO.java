package sistemalogin.trabalhofinal.dao;

import sistemalogin.trabalhofinal.mensagem.Msg;

import java.util.ArrayList;

public interface MensagemDAO {
    public ArrayList<Msg> listarMensagensUsuario(int idUsuario) throws Exception;
    public ArrayList<Msg> listarMensagens() throws Exception;
    public void excluirMensagem(int id);
    public Msg consultarMensagen(int id) throws Exception;
    public void cadastrarMensagens(Msg Msg);
    public boolean isEmpty() throws Exception;
    void fecharConexao();
}
