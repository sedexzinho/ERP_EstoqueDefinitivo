package org.example.service.controller;

import org.example.exception.NomeJaCadastrado;
import org.example.exception.ProdutoJaCadastradoException;

import org.example.model.Eletronicos;

import org.example.service.EletronicoService;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/produtoEletronicos")
public class EletronicosController {


    @PostMapping("/cadastro")
    public String cadastrarProduto(@RequestBody Eletronicos eletronicos) throws SQLException, NomeJaCadastrado, ProdutoJaCadastradoException {
        Eletronicos produto_eletronico = new Eletronicos(
                eletronicos.getCodigo(),
                eletronicos.getNome(),
                eletronicos.getPrecoCusto(),
                eletronicos.getPrecoVenda(),
                eletronicos.getQuantidadeEstoque(),
                eletronicos.getMarca(),
                eletronicos.getArmazenamento(),
                eletronicos.getTipo(),
                eletronicos.getModelo()

        );

        EletronicoService.adicionarProdutoEletronico(eletronicos);
        String mensagem = "produto cadastrado";
        System.out.println(mensagem);
        return mensagem;

    }


}
