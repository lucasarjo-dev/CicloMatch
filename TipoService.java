package org.example.service;

import org.example.dao.TipoDao;
import org.example.model.Tipo;

import java.sql.SQLException;
import java.util.List;

public class TipoService {

    private TipoDao dao = new TipoDao();

    public void cadastrar(String nome) throws SQLException {
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }
        dao.inserir(new Tipo(0, nome.trim()));
    }

    public List<Tipo> listar() throws SQLException {
        return dao.listar();
    }
}
