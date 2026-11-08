package org.example.dao;

import org.example.factory.ConnectionFactory;
import org.example.model.Gerador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeradorDao {

    public void inserir(Gerador g) throws SQLException {
        String sql = "INSERT INTO gerador (nome, endereco, numero, bairro, estado, email_contato, cpf, cnpj) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection c = ConnectionFactory.getConexao(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, g.getNome());
            ps.setString(2, g.getEndereco());
            ps.setString(3, g.getNumero());
            ps.setString(4, g.getBairro());
            ps.setString(5, g.getEstado());
            ps.setString(6, g.getEmailContato());
            ps.setString(7, g.getCpf());
            ps.setString(8, g.getCnpj());
            ps.executeUpdate();
        }
    }

    public List<Gerador> listar() throws SQLException {
        List<Gerador> lista = new ArrayList<>();
        try (Connection c = ConnectionFactory.getConexao();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM gerador");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Gerador(rs.getInt("cod_gerador"), rs.getString("nome"),
                        rs.getString("endereco"), rs.getString("numero"), rs.getString("bairro"),
                        rs.getString("estado"), rs.getString("email_contato"),
                        rs.getString("cpf"), rs.getString("cnpj")));
            }
        }
        return lista;
    }
}
