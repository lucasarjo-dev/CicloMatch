package org.example.dao;

import org.example.factory.ConnectionFactory;
import org.example.model.Tipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoDao {

    public void inserir(Tipo t) throws SQLException {
        String sql = "INSERT INTO tipo (nome) VALUES (?)";
        try (Connection c = ConnectionFactory.getConexao(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, t.getNome());
            ps.executeUpdate();
        }
    }

    public List<Tipo> listar() throws SQLException {
        List<Tipo> lista = new ArrayList<>();
        try (Connection c = ConnectionFactory.getConexao();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM tipo");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Tipo(rs.getInt("cod_tipo"), rs.getString("nome")));
            }
        }
        return lista;
    }
}
