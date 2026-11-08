package org.example.dao;

import org.example.factory.ConnectionFactory;
import org.example.model.ReceptorGeradorTipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReceptorGeradorTipoDao {

    public void inserir(ReceptorGeradorTipo r) throws SQLException {
        String sql = "INSERT INTO receptor_gerador_tipo (cod_receptor, cod_gerador_tipo, quantidade, data) "
                   + "VALUES (?, ?, ?, ?)";
        try (Connection c = ConnectionFactory.getConexao(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, r.getCodReceptor());
            ps.setInt(2, r.getCodGeradorTipo());
            ps.setDouble(3, r.getQuantidade());
            ps.setObject(4, r.getData());
            ps.executeUpdate();
        }
    }

    public List<ReceptorGeradorTipo> listar() throws SQLException {
        List<ReceptorGeradorTipo> lista = new ArrayList<>();
        try (Connection c = ConnectionFactory.getConexao();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM receptor_gerador_tipo");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new ReceptorGeradorTipo(rs.getInt("cod_receptor_gerador_tipo"),
                        rs.getInt("cod_receptor"), rs.getInt("cod_gerador_tipo"),
                        rs.getDouble("quantidade"), rs.getObject("data", LocalDate.class)));
            }
        }
        return lista;
    }
}
