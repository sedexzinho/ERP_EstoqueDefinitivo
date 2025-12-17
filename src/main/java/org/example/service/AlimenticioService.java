package org.example.service;

import org.example.exception.NomeJaCadastrado;
import org.example.exception.ProdutoJaCadastradoException;
import org.example.infrastructure.ConexaoBD;
import org.example.model.Alimenticio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlimenticioService {
    public static Alimenticio adicionarProdutoAlimenticio(Alimenticio alimenticio) throws SQLException, ProdutoJaCadastradoException, NomeJaCadastrado {
        String sql = """
                INSERT INTO produto_alimenticio (codigo, nome, precoCusto, precoVenda, quantidadeEstoque, dataValidade, materialEmbalagem, peso) VALUES (?,?,?,?,?,?,?,?);
                """;
        try (Connection conn = ConexaoBD.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, alimenticio.getCodigo());
            stmt.setString(2, alimenticio.getNome());
            stmt.setDouble(3, alimenticio.getPrecoCusto());
            stmt.setDouble(4, alimenticio.getPrecoVenda());
            stmt.setInt(5, alimenticio.getQuantidadeEstoque());
            stmt.setString(6, alimenticio.getDataValidade());
            stmt.setString(7, alimenticio.getMaterialEmbalagem());
            stmt.setDouble(8, alimenticio.getPeso());
            stmt.executeUpdate();
            System.out.println("Produto adicionado com sucesso!");
        } catch (SQLException ex) {
            throw new ProdutoJaCadastradoException(ex.getMessage());
        }
        return alimenticio;
    }
}
