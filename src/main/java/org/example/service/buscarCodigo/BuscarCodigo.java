package org.example.service.buscarCodigo;

import org.example.exception.NomeJaCadastrado;
import org.example.exception.ProdutoJaCadastradoException;
import org.example.infrastructure.ConexaoBD;
import org.example.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuscarCodigo {
    //VESTUARIO
    private Vestuario mapResultSetToProdutoVestuario(ResultSet rs) throws SQLException {
        return new Vestuario(
                rs.getString("codigo"),
                rs.getString("nome"),
                rs.getDouble("precoCusto"),
                rs.getDouble("precoVenda"),
                rs.getInt("quantidadeEstoque"),
                rs.getString("tamanho"),
                rs.getString("cor"),
                rs.getString("tecido")

        );

    }

    //ALIMENTICIO
    private Alimenticio mapResultSetToProdutoAlimenticio(ResultSet rs) throws SQLException {
        return new Alimenticio(
                rs.getString("codigo"),
                rs.getString("nome"),
                rs.getDouble("precoCusto"),
                rs.getDouble("precoVenda"),
                rs.getInt("quantidadeEstoque"),
                rs.getString("dataValidade"),
                rs.getString("materialEmbalagem"),
                rs.getDouble("peso")

        );
    }

    //ELETRONICOS
    private Eletronicos mapResultSetToProdutoEletronico(ResultSet rs) throws SQLException {
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

    //LIMPEZA
    private Limpeza mapResultSetToProdutoLimpeza(ResultSet rs) throws SQLException {
        return new Limpeza(
                rs.getString("codigo"),
                rs.getString("nome"),
                rs.getDouble("precoCusto"),
                rs.getDouble("precoVenda"),
                rs.getInt("quantidadeEstoque"),
                rs.getString("biodegradavel"),
                rs.getString("perfume"),
                rs.getString("tipo"),
                rs.getString("volumeML")

        );

    }
    //ELETRODOMESTICO
    private Eletrodomestico mapResultSetToProdutoEletrodomestico(ResultSet rs) throws SQLException {
        return new Eletrodomestico(
                rs.getString("codigo"),
                rs.getString("nome"),
                rs.getDouble("precoCusto"),
                rs.getDouble("precoVenda"),
                rs.getInt("quantidadeEstoque"),
                rs.getString("marca"),
                rs.getString("modelo"),
                rs.getString("cor"),
                rs.getInt("votagemSuportada"),
                rs.getInt("potenciaWatts"),
                rs.getDouble("pesoKG")

        );
    }
public Eletrodomestico buscarPorCodigoEletrodomestico(String codigo) throws SQLException{
       String sql = "SELECT * FROM produto_eletrodomestico WHERE codigo = ?";
    try (Connection conn = ConexaoBD.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, codigo);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return mapResultSetToProdutoEletrodomestico(rs);
        }
    }
    return null;
}



    public Limpeza buscarPorCodigoLimpeza(String codigo) throws SQLException {
        String sql = "SELECT * FROM produto_limpeza WHERE codigo = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToProdutoLimpeza(rs);
            }
        }
        return null;
    }


    public Eletronicos buscarPorCodigoEletronico(String codigo) throws SQLException {
        String sql = "SELECT * FROM produto_eletronico WHERE codigo = ?";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToProdutoEletronico(rs);
            }
        }
        return null;
    }


    public Alimenticio buscarPorCodigoAlimenticio(String codigo) throws ProdutoJaCadastradoException, NomeJaCadastrado, SQLException {
        String sql = " SELECT * FROM produto_alimenticio WHERE codigo = ? ";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToProdutoAlimenticio(rs);
            }
        }
        return null;

    }


    public Vestuario buscarPorCodigoVestuario(String codigo) throws SQLException {
        String sql = " SELECT * FROM produto_vestuario WHERE codigo = ? ";
        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToProdutoVestuario(rs);
            }
        }
        return null;

    }
}
