package org.example.dao;

import org.example.factory.ConnectionFactory;
import org.example.model.Receptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReceptorDao {

    public void inserir(Receptor r) throws SQLException {
        String sql = "INSERT INTO receptor (nome, email, cpf, cnpj) VALUES (?, ?, ?, ?)";
        try (Connection c = ConnectionFactory.getConexao(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, r.getNome());
            ps.setString(2, r.getEmail());
            ps.setString(3, r.getCpf());
            ps.setString(4, r.getCnpj());
            ps.executeUpdate();
        }
    }

    public List<Receptor> listar() throws SQLException {
        List<Receptor> lista = new ArrayList<>();
        try (Connection c = ConnectionFactory.getConexao();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM receptor");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Receptor(rs.getInt("cod_receptor"), rs.getString("nome"),
                        rs.getString("email"), rs.getString("cpf"), rs.getString("cnpj")));
            }
        }
        return lista;
    }
}
