package org.example.dao;

import org.example.factory.ConnectionFactory;
import org.example.model.GeradorTipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GeradorTipoDao {

    public void inserir(GeradorTipo gt) throws SQLException {
        String sql = "INSERT INTO gerador_tipo (cod_gerador, cod_tipo, quantidade, data) VALUES (?, ?, ?, ?)";
        try (Connection c = ConnectionFactory.getConexao(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, gt.getCodGerador());
            ps.setInt(2, gt.getCodTipo());
            ps.setDouble(3, gt.getQuantidade());
            ps.setObject(4, gt.getData());
            ps.executeUpdate();
        }
    }

    public List<GeradorTipo> listar() throws SQLException {
        List<GeradorTipo> lista = new ArrayList<>();
        try (Connection c = ConnectionFactory.getConexao();
             PreparedStatement ps = c.prepareStatement("SELECT * FROM gerador_tipo");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new GeradorTipo(rs.getInt("cod_gerador_tipo"), rs.getInt("cod_gerador"),
                        rs.getInt("cod_tipo"), rs.getDouble("quantidade"),
                        rs.getObject("data", LocalDate.class)));
            }
        }
        return lista;
    }
}
