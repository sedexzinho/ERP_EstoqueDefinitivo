package org.example.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String URL = "jdbc:postgresql://localhost:5432/MeuNovoERP";
    private static final String USER = "postgres";
    private static final String PASSWORD = "4546";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void inicializarBanco() throws SQLException {
        criarTabelaVestuario();
        criarTabelaAlimenticio();
        criarTabelaEletronicos();
        criarTabelaEletrodomestico();
        criarTabelaLimpeza();
        System.out.println("Todas as tabelas foram criadas com sucesso!");
    }

    private static void criarTabelaVestuario() throws SQLException {
        String sql = """
                    CREATE TABLE IF NOT EXISTS produto_vestuario (
                        codigo VARCHAR(50) PRIMARY KEY,
                        nome VARCHAR(100) UNIQUE NOT NULL,
                        precoCusto NUMERIC(10,2) NOT NULL,
                        precoVenda NUMERIC(10,2) NOT NULL,
                        quantidadeEstoque INT NOT NULL,
                        tamanho VARCHAR(10),
                        cor VARCHAR(50),
                        tecido VARCHAR(50)
                    )
                """;
        executarSQL(sql, "produto_vestuario");
    }

    private static void criarTabelaAlimenticio() throws SQLException {
        String sql = """
                    CREATE TABLE IF NOT EXISTS produto_alimenticio (
                        codigo VARCHAR(50) PRIMARY KEY,
                        nome VARCHAR(100) UNIQUE NOT NULL,
                        precoCusto NUMERIC(10,2) NOT NULL,
                        precoVenda NUMERIC(10,2) NOT NULL,
                        quantidadeEstoque INT NOT NULL,
                        dataValidade VARCHAR(20),
                        materialEmbalagem VARCHAR(50),
                        peso NUMERIC(10,3)
                    )
                """;
        executarSQL(sql, "produto_alimenticio");
    }

    private static void criarTabelaEletronicos() throws SQLException {
        String sql = """
                    CREATE TABLE IF NOT EXISTS produto_eletronico (
                        codigo VARCHAR(50) PRIMARY KEY,
                        nome VARCHAR(100) UNIQUE NOT NULL,
                        precoCusto NUMERIC(10,2) NOT NULL,
                        precoVenda NUMERIC(10,2) NOT NULL,
                        quantidadeEstoque INT NOT NULL,
                        tipo VARCHAR(50),
                        armazenamento INT,
                        marca VARCHAR(50),
                        modelo VARCHAR(50)
                    )
                """;
        executarSQL(sql, "produto_eletronico");
    }

    private static void criarTabelaEletrodomestico() throws SQLException {
        String sql = """
                    CREATE TABLE IF NOT EXISTS produto_eletrodomestico (
                        codigo VARCHAR(50) PRIMARY KEY,
                        nome VARCHAR(100) UNIQUE NOT NULL,
                        precoCusto NUMERIC(10,2) NOT NULL,
                        precoVenda NUMERIC(10,2) NOT NULL,
                        quantidadeEstoque INT NOT NULL,
                        marca VARCHAR(50),
                        modelo VARCHAR(50),
                        cor VARCHAR(50),
                        voltagemSuportada INT,
                        potenciaWatts INT,
                        pesoKG NUMERIC(10,2)
                    )
                """;
        executarSQL(sql, "produto_eletrodomestico");
    }



   private static void criarTabelaLimpeza() throws SQLException {
        String sql = """
                    CREATE TABLE IF NOT EXISTS produto_limpeza (
                        codigo VARCHAR(50) PRIMARY KEY,
                        nome VARCHAR(100) UNIQUE NOT NULL,
                        precoCusto NUMERIC(10,2) NOT NULL,
                        precoVenda NUMERIC(10,2) NOT NULL,
                        quantidadeEstoque INT NOT NULL,
                        volumeML VARCHAR(20),
                        tipo VARCHAR(50),
                        perfume VARCHAR(50),
                        biodegradavel BOOLEAN
                    )
                """;
        executarSQL(sql, "produto_limpeza");
    }

    private static void executarSQL(String sql, String nomeTabela) throws SQLException {
        try (Connection conn = getConnection();
             var stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Tabela '" + nomeTabela + "' pronta!");
        }
    }
}
