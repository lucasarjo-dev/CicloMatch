package org.example.service;

import org.example.dao.GeradorTipoDao;
import org.example.model.GeradorTipo;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class GeradorTipoService {

    private GeradorTipoDao dao = new GeradorTipoDao();

    public void registrar(int codGerador, int codTipo, String quantidade, String data) throws SQLException {
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
        dao.inserir(new GeradorTipo(0, codGerador, codTipo, q, d));
    }

    public List<GeradorTipo> listar() throws SQLException {
        return dao.listar();
    }
}
