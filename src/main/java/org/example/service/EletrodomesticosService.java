package org.example.service;

import org.example.exception.NomeJaCadastrado;
import org.example.exception.ProdutoJaCadastradoException;
import org.example.infrastructure.ConexaoBD;
import org.example.model.Eletrodomestico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EletrodomesticosService {
    public static Eletrodomestico adicionarProdutoEletrodomestico(Eletrodomestico eletroDomesticos) throws ProdutoJaCadastradoException, SQLException, NomeJaCadastrado {

        String sql = """
                INSERT INTO produto_eletrodomestico  (codigo,
                    nome,
                    precoCusto,
                    precoVenda,
                    quantidadeEstoque,
                    marca,
                    modelo,
                    cor,
                    voltagemSuportada,
                    potenciaWatts,
                    pesoKG    
                    ) VALUES (?,?,?,?,?,?,?,?,?,?,?);
                """;

        try (Connection conn = ConexaoBD.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, eletroDomesticos.getCodigo());
            stmt.setString(2, eletroDomesticos.getNome());
            stmt.setDouble(3, eletroDomesticos.getPrecoCusto());
            stmt.setDouble(4, eletroDomesticos.getPrecoVenda());
            stmt.setInt(5, eletroDomesticos.getQuantidadeEstoque());
            stmt.setString(6, eletroDomesticos.getMarca());
            stmt.setString(7, eletroDomesticos.getModelo());
            stmt.setString(8, eletroDomesticos.getCor());
            stmt.setInt(9, eletroDomesticos.getVoltagemSuportada());
            stmt.setInt(10, eletroDomesticos.getPotenciaWatts());
            stmt.setDouble(11, eletroDomesticos.getPesoKG());

            stmt.executeUpdate();
            System.out.println("Produto adicionado com sucesso!");
        } catch (SQLException ex) {
            throw new ProdutoJaCadastradoException(ex.getMessage());
        }
        return eletroDomesticos;
    }


}
