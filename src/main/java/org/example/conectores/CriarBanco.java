package org.example.conectores;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
        private static final String URL = "jdbc:postgresql://localhost:5432/postgres"; // conecta no banco padrão
        private static final String USER = "postgres";
        private static final String PASSWORD = "4546";

        public static void main(String[] args) {
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stmt = conn.createStatement()) {

                stmt.executeUpdate("CREATE DATABASE \"MeuNovoERP\"");
                System.out.println("Banco 'MeuNovoERP' criado com sucesso!");

            } catch (SQLException e) {
                System.err.println("Erro ao criar banco: " + e.getMessage());
            }
        }
    }


