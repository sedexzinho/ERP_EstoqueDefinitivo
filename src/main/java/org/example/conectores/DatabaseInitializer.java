package org.example.conectores;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public void criarTabelaProduto() {
        String sql = """
                CREATE TABLE IF NOT EXISTS produto(
                codigo VARCHAR(50) PRIMARY KEY NOT NULL,
                nome VARCHAR(100) NOT NULL,
                precoCusto DOUBLE NOT NULL,
                precoVenda DOUBLE NOT NULL,
                quantidadeEstoque INT NOT NULL);""";
        try (Connection conn = ConexaoBD.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'produto' criada/verificada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

