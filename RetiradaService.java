package org.example.service;

import org.example.dao.ReceptorGeradorTipoDao;
import org.example.model.ReceptorGeradorTipo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class RetiradaService {

    private ReceptorGeradorTipoDao dao = new ReceptorGeradorTipoDao();

    public void registrar(int codReceptor, int codGeradorTipo, String quantidade, String data) throws SQLException {
        double q;
        LocalDate d;
        try {
            q = Double.parseDouble(quantidade.trim().replace(',', '.'));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Quantidade inválida. Digite um número, como 50 ou 12.5.");
        }
        if (q <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        try {
            d = LocalDate.parse(data.trim());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data inválida. Use aaaa-mm-dd, por exemplo 2026-10-28.");
        }
        dao.inserir(new ReceptorGeradorTipo(0, codReceptor, codGeradorTipo, q, d));
    }

    public List<ReceptorGeradorTipo> listar() throws SQLException {
        return dao.listar();
    }
}
