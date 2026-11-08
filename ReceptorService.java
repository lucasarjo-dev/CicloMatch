package org.example.service;

import org.example.dao.ReceptorDao;
import org.example.model.Receptor;

import java.sql.SQLException;
import java.util.List;

public class ReceptorService {

    private ReceptorDao dao = new ReceptorDao();

    public void cadastrar(String nome, String email, String cpf, String cnpj) throws SQLException {
        if (nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }
        if (cpf.trim().isEmpty() && cnpj.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe o CPF ou o CNPJ.");
        }
        if (cpf.trim().isEmpty()) {
            cpf = null;
        }
        if (cnpj.trim().isEmpty()) {
            cnpj = null;
        }
        dao.inserir(new Receptor(0, nome.trim(), email, cpf, cnpj));
    }

    public List<Receptor> listar() throws SQLException {
        return dao.listar();
    }
}
