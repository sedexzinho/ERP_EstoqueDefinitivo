package org.example.conectores;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {

        try (Connection conn = ConexaoBD.getConnection()) {
            System.out.println("Conexão bem-sucedida com PostgreSQL!");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
    }
}
