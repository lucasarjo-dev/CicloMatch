package org.example.app;

import org.example.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try (Connection conn = ConnectionFactory.getConexao()) {
            System.out.println("Conectado ao banco: " + conn.getCatalog());
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar ao banco: " + e.getMessage());
            return;
        }

        Menu menu = new Menu();
        menu.executar();
    }
}
