package org.example.model;

public class Receptor {
    private int codReceptor;
    private String nome;
    private String email;
    private String cpf;
    private String cnpj;

    public Receptor(int codReceptor, String nome, String email, String cpf, String cnpj) {
        this.codReceptor = codReceptor;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cnpj = cnpj;
    }

    public int getCodReceptor() { return codReceptor; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public String getCnpj() { return cnpj; }
}
