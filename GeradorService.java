package org.example.service;

import org.example.dao.GeradorDao;
import org.example.model.Gerador;

import java.sql.SQLException;
import java.util.List;

public class GeradorService {

    private GeradorDao dao = new GeradorDao();

    public void cadastrar(String nome, String endereco, String numero, String bairro, String estado,
                          String email, String cpf, String cnpj) throws SQLException {
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
        dao.inserir(new Gerador(0, nome.trim(), endereco, numero, bairro, estado.toUpperCase(), email, cpf, cnpj));
    }

    public List<Gerador> listar() throws SQLException {
        return dao.listar();
    }
}
