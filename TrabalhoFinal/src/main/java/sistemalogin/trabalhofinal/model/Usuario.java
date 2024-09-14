package sistemalogin.trabalhofinal.model;


import sistemalogin.trabalhofinal.mensagem.Msg;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    //atibutos do usuario
    private String nome;
    private String senha;

    //private final LocalDate dataCadastro;

    private double notificacoesRecebidas;
    private double notificacoesLidas;
    private Estado estado;

    private List<Msg> mensagens;

    private int id;
    private boolean aprovado;


    //-------------------------
//    public LocalDate getDataCadastro() {
//        return dataCadastro;
//    }

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

    public List<Msg> getMensagens() {
        return mensagens;
    }

    public void addMensagem(Msg msg) {
        this.mensagens.add(msg);
    }
//-------------------------

    public Usuario(int id , String nome, String senha, double notificacoesLidas, double notificacoesRecebidas, String tipo, Boolean aprovado) {
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

        }

        this.aprovado = aprovado;

    }

    public Usuario(String nome, String senha, boolean isPrimeiroCadastro)
    {
        this.nome = nome;
        this.senha = senha;

        this.notificacoesLidas = 0;
        this.notificacoesRecebidas = 0;
        this.mensagens = new ArrayList<>();

        this.aprovado = isPrimeiroCadastro;

        this.estado = isPrimeiroCadastro ? new Adm(this) : new User(this);
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

    public boolean isAprovado() {
       return this.estado.isAprovado();
    }
    public void setAprovado() {
        estado.setAprovado();
    }


    public int getId() {
        return id;
    }

}
