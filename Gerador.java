package org.example.model;

public class Gerador {
    private int codGerador;
    private String nome;
    private String endereco;
    private String numero;
    private String bairro;
    private String estado;
    private String emailContato;
    private String cpf;
    private String cnpj;

    public Gerador(int codGerador, String nome, String endereco, String numero, String bairro,
                   String estado, String emailContato, String cpf, String cnpj) {
        this.codGerador = codGerador;
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.estado = estado;
        this.emailContato = emailContato;
        this.cpf = cpf;
        this.cnpj = cnpj;
    }

    public int getCodGerador() { return codGerador; }
    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getNumero() { return numero; }
    public String getBairro() { return bairro; }
    public String getEstado() { return estado; }
    public String getEmailContato() { return emailContato; }
    public String getCpf() { return cpf; }
    public String getCnpj() { return cnpj; }
}
