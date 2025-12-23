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

public class EletronicoService {
    public static Eletronicos adicionarProdutoEletronico(Eletronicos eletronicos) throws SQLException, ProdutoJaCadastradoException, NomeJaCadastrado {
        String sql = """
                INSERT INTO produto_eletronico (codigo, nome, precoCusto, precoVenda, quantidadeEstoque, tipo, armazenamento, marca, modelo) VALUES (?,?,?,?,?,?,?,?,?);
                """;
        try (Connection conn = ConexaoBD.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, eletronicos.getCodigo());
            stmt.setString(2, eletronicos.getNome());
            stmt.setDouble(3, eletronicos.getPrecoCusto());
            stmt.setDouble(4, eletronicos.getPrecoVenda());
            stmt.setInt(5, eletronicos.getQuantidadeEstoque());
            stmt.setString(6, eletronicos.getTipo());
            stmt.setInt(7, eletronicos.getArmazenamento());
            stmt.setString(8, eletronicos.getMarca());
            stmt.setString(9, eletronicos.getModelo());

            stmt.executeUpdate();
            System.out.println("Produto adicionado com sucesso!");
        } catch (SQLException ex) {
            throw new ProdutoJaCadastradoException(ex.getMessage());
        }

        return null;
    }

    private Eletronicos mapResultSetToProduto(ResultSet rs) throws SQLException {
        return new Eletronicos(
                rs.getString("codigo"),
                rs.getString("nome"),
                rs.getDouble("precoCusto"),
                rs.getDouble("precoVenda"),
                rs.getInt("quantidadeEstoque"),
                rs.getString("tipo"),
                rs.getInt("armazenamento"),
                rs.getString("marca"),
                rs.getString("modelo")

        );

    }

    public Eletronicos buscarPorCodigo(String codigo) throws ProdutoJaCadastradoException, NomeJaCadastrado, SQLException {
        String sql = " SELECT * FROM produto_eletronico WHERE ncodigo = ? ";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToProduto(rs);
            }
        }
        return null;

    }
}
