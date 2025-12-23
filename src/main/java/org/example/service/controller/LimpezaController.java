package org.example.service.controller;

import org.example.exception.NomeJaCadastrado;
import org.example.exception.ProdutoJaCadastradoException;

import org.example.model.Limpeza;


import org.example.service.LimpezaService;
import org.example.service.buscarCodigo.BuscarCodigo;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/produtoLimpeza")

public class LimpezaController {

    private final BuscarCodigo buscarCodigo =  new BuscarCodigo();
    @PostMapping("/cadastro")
    public String cadastrarProduto(@RequestBody Limpeza limpezaRequest) throws NomeJaCadastrado, SQLException, ProdutoJaCadastradoException {
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
@GetMapping("/buscarCodigo/{codigo}")
    public Limpeza buscarCodigo(@PathVariable String codigo) throws SQLException {
        return buscarCodigo.buscarPorCodigoLimpeza(codigo);
}

}
