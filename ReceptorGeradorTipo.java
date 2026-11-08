package org.example.model;

import java.time.LocalDate;

public class ReceptorGeradorTipo {
    private int codReceptorGeradorTipo;
    private int codReceptor;
    private int codGeradorTipo;
    private double quantidade;
    private LocalDate data;

    public ReceptorGeradorTipo(int codReceptorGeradorTipo, int codReceptor, int codGeradorTipo,
                               double quantidade, LocalDate data) {
        this.codReceptorGeradorTipo = codReceptorGeradorTipo;
        this.codReceptor = codReceptor;
        this.codGeradorTipo = codGeradorTipo;
        this.quantidade = quantidade;
        this.data = data;
    }

    public int getCodReceptorGeradorTipo() { return codReceptorGeradorTipo; }
    public int getCodReceptor() { return codReceptor; }
    public int getCodGeradorTipo() { return codGeradorTipo; }
    public double getQuantidade() { return quantidade; }
    public LocalDate getData() { return data; }
}
