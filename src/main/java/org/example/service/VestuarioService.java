package org.example.service;

import org.example.exception.NomeJaCadastrado;
import org.example.exception.ProdutoJaCadastradoException;
import org.example.infrastructure.ConexaoBD;
import org.example.model.Eletronicos;
import org.example.model.Vestuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VestuarioService extends ConexaoBD {
    Vestuario vestuario;
    private static final String TABELA = "produto_vestuario";

    public static Vestuario adicionarProdutoVestuario(Vestuario vestuario) throws SQLException, ProdutoJaCadastradoException, NomeJaCadastrado {
        String sql = """
                INSERT INTO produto_vestuario (codigo, nome, precoCusto, precoVenda, quantidadeEstoque, tamanho, cor, tecido) VALUES (?,?,?,?,?,?,?,?);
                """;
        try (Connection conn = ConexaoBD.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, vestuario.getCodigo());
            stmt.setString(2, vestuario.getNome());
            stmt.setDouble(3, vestuario.getPrecoCusto());
            stmt.setDouble(4, vestuario.getPrecoVenda());
            stmt.setInt(5, vestuario.getQuantidadeEstoque());
            stmt.setString(6, vestuario.getTamanho());
            stmt.setString(7, vestuario.getCor());
            stmt.setString(8, vestuario.getTecido());
            stmt.executeUpdate();
            System.out.println("Produto adicionado com sucesso!");
        } catch (SQLException ex) {
            throw new ProdutoJaCadastradoException(ex.getMessage());
        }
        return vestuario;
    }






}
