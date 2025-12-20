package org.example.controller;

import org.example.controller.request.LimpezaRequest;
import org.example.exception.NomeJaCadastrado;
import org.example.exception.ProdutoJaCadastradoException;

import org.example.model.Limpeza;

import org.example.service.EstoqueService;
import org.example.service.LimpezaService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/produtoLimpeza")
public class LimpezaController {
EstoqueService estoqueService = new EstoqueService();
    @PostMapping("/cadastro")
    public String cadastrarProduto(@RequestBody LimpezaRequest limpezaRequest) throws NomeJaCadastrado, SQLException, ProdutoJaCadastradoException {
        Limpeza produto_limpeza = new Limpeza(
                limpezaRequest.getCodigo(),
                limpezaRequest.getNome(),
                limpezaRequest.getPrecoCusto(),
                limpezaRequest.getPrecoVenda(),
                limpezaRequest.getQuantidadeEstoque(),
                limpezaRequest.getVolumeML(),
                limpezaRequest.getTipo(),
                limpezaRequest.getPerfume(),
                limpezaRequest.getBiodegradavel()


        );
        LimpezaService.adicionarProdutoLimpeza(limpezaRequest);
        String mensagem = "produto cadastrado";
        return mensagem;
    }
}
