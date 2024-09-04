package sistemalogin.trabalhofinal.Model;


import sistemalogin.trabalhofinal.Mensagem.Mesagem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    //atibutos do usuario
    private String nome;
    private String senha;

    private final LocalDate dataCadastro;

    private double notificacoesRecebidas;
    private double notificacoesLidas;
    private Estado estado;

    public List<Mesagem> mensagens;


    //-------------------------
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public double getNotificacoesRecebidas() {
        return notificacoesRecebidas;
    }

    public void setNotificacoesRecebidas(double notificacoesRecebidas) {
        this.notificacoesRecebidas = notificacoesRecebidas;
    }

    public double getNotificacoesLidas() {
        return notificacoesLidas;
    }

    public void setNotificacoesLidas(double notificacoesLidas) {
        this.notificacoesLidas = notificacoesLidas;
    }

    public List<Mesagem> getMensagens() {
        return mensagens;
    }

    public void addMensagem(Mesagem mensagem) {
        this.mensagens.add(mensagem);
    }
//-------------------------

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.mensagens = new ArrayList<>();
        this.notificacoesLidas = 0;
        this.notificacoesRecebidas = 0;
        this.dataCadastro = LocalDate.now();
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

    public void criarUsuario(){
        estado.criarUsuario();
    }

    public void aprovarUsuario(){
        estado.aprovarUsuario();
    }

    public void deletarUsuario(){
        estado.deletarUsuario();
    }

    public void isAprovado() {
       estado.isAprovado();
    }
    public void setAprovado() {
        estado.setAprovado();
    }






}
