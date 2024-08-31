package sistemalogin.trabalhofinal.Model;

public class Usuario {

    //atibutos do usuario
    private String nome;
    private String login;
    private String senha;

    private Estado estado;

    //-------------------------

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }


    private String getNome() {
        return nome;
    }


    private String getSenha() {
        return senha;
    }

    public void alterarSenha(){
        // metodos para alterar a senha
    }

    private String getNomeEstado() {
        return estado.getNomeEstado();
    }






}
