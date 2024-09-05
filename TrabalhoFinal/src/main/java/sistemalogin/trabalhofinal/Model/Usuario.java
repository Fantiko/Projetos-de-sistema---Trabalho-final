package sistemalogin.trabalhofinal.Model;


import sistemalogin.trabalhofinal.Mensagem.Mesagem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {

    //atibutos do usuario
    private String nome;
    private String senha;

    private final LocalDate dataCadastro;

    private double notificacoesRecebidas;
    private double notificacoesLidas;
    private Estado estado;

    private List<Mesagem> mensagens;

    private final int id;
    private boolean aprovado;

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

    public Usuario(int id , String nome, String senha, double notificacoesLidas, double notificacoesRecebidas, String tipo, Boolean aprovado) throws Exception {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.mensagens = new ArrayList<>();
        this.notificacoesLidas = notificacoesLidas;
        this.notificacoesRecebidas = notificacoesRecebidas;
        //this.dataCadastro = LocalDate.now();

        if ("adm".equalsIgnoreCase(tipo)){
            this.estado = new Adm(this);

        } else if ("user".equalsIgnoreCase(tipo)) {
            this.estado = new User(this);

        }else {
            throw new Exception();
        }

        this.aprovado = aprovado;

    }


    public String getNome() {
        return nome;
    }


    public String getSenha() {
        return senha;
    }

    public void alterarSenha(){
        // metodos para alterar a senha
    }

    public String getNomeEstado() {
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


    public int getId() {
        return id;
    }

}
