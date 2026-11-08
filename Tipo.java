package org.example.model;

public class Tipo {
    private int codTipo;
    private String nome;

    public Tipo(int codTipo, String nome) {
        this.codTipo = codTipo;
        this.nome = nome;
    }

    public int getCodTipo() { return codTipo; }
    public String getNome() { return nome; }
}
