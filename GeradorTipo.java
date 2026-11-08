package org.example.model;

import java.time.LocalDate;

public class GeradorTipo {
    private int codGeradorTipo;
    private int codGerador;
    private int codTipo;
    private double quantidade;
    private LocalDate data;

    public GeradorTipo(int codGeradorTipo, int codGerador, int codTipo, double quantidade, LocalDate data) {
        this.codGeradorTipo = codGeradorTipo;
        this.codGerador = codGerador;
        this.codTipo = codTipo;
        this.quantidade = quantidade;
        this.data = data;
    }

    public int getCodGeradorTipo() { return codGeradorTipo; }
    public int getCodGerador() { return codGerador; }
    public int getCodTipo() { return codTipo; }
    public double getQuantidade() { return quantidade; }
    public LocalDate getData() { return data; }
}
