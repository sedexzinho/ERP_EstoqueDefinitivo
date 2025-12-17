package org.example.controller;

import org.example.controller.request.AlimenticioRequest;
import org.example.exception.NomeJaCadastrado;
import org.example.exception.ProdutoJaCadastradoException;
import org.example.model.Alimenticio;
import org.example.service.AlimenticioService;
import org.example.service.VestuarioService;
import org.example.service.EstoqueService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/produtoAlimenticio")
public class AlimenticioController {
    EstoqueService estoqueService = new EstoqueService();

    @PostMapping("/cadastro")
    public String cadastrarProduto(@RequestBody AlimenticioRequest alimenticioRequest) throws NomeJaCadastrado, SQLException, ProdutoJaCadastradoException {
        Alimenticio produto_alimenticio = new Alimenticio(
                alimenticioRequest.getCodigo(),
                alimenticioRequest.getNome(),
                alimenticioRequest.getPrecoCusto(),
                alimenticioRequest.getPrecoVenda(),
                alimenticioRequest.getQuantidadeEstoque(),
                alimenticioRequest.getDataValidade(),
                alimenticioRequest.getMaterialEmbalagem(),
                alimenticioRequest.getPeso()
        );
        AlimenticioService.adicionarProdutoAlimenticio(produto_alimenticio);
        String mensagem = "produto cadastrado";
        return mensagem;
    }
}
