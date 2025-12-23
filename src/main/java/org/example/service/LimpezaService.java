package org.example.service;

import org.example.exception.NomeJaCadastrado;
import org.example.exception.ProdutoJaCadastradoException;
import org.example.infrastructure.ConexaoBD;
import org.example.model.Eletronicos;
import org.example.model.Limpeza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LimpezaService {
    public static Limpeza adicionarProdutoLimpeza(Limpeza limpezaRequest) throws SQLException, ProdutoJaCadastradoException, NomeJaCadastrado {
        String sql = """
                INSERT INTO produto_limpeza (codigo, nome, precoCusto, precoVenda, quantidadeEstoque, volumeML, tipo, perfume, biodegradavel) VALUES (?,?,?,?,?,?,?,?,?);
                """;
        try (Connection conn = ConexaoBD.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, limpezaRequest.getCodigo());
            stmt.setString(2, limpezaRequest.getNome());
            stmt.setDouble(3, limpezaRequest.getPrecoCusto());
            stmt.setDouble(4, limpezaRequest.getPrecoVenda());
            stmt.setInt(5, limpezaRequest.getQuantidadeEstoque());
            stmt.setString(6, limpezaRequest.getVolumeML());
            stmt.setString(7, limpezaRequest.getTipo());
            stmt.setString(8, limpezaRequest.getPerfume());
            stmt.setString(9,limpezaRequest.getBiodegradavel());
            stmt.executeUpdate();
            System.out.println("Produto adicionado com sucesso!");
        } catch (SQLException ex) {
            throw new ProdutoJaCadastradoException(ex.getMessage());
        }

        return null;
    }

}
