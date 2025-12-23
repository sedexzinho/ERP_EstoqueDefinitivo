package org.example.service.controller;

import org.example.exception.NomeJaCadastrado;
import org.example.exception.ProdutoJaCadastradoException;
import org.example.model.Eletrodomestico;
import org.example.service.EletrodomesticosService;


import org.example.service.buscarCodigo.BuscarCodigo;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/produtoEletrodomestico")
public class EletrodomesticoController {

    private final BuscarCodigo buscarCodigo =  new BuscarCodigo();
    @PostMapping("/cadastro")
    public String cadastrarProduto(@RequestBody Eletrodomestico eletrodomestico) throws NomeJaCadastrado, SQLException, ProdutoJaCadastradoException {
        Eletrodomestico produto_eletrodomestico = new Eletrodomestico(
                eletrodomestico.getCodigo(),
                eletrodomestico.getNome(),
                eletrodomestico.getPrecoCusto(),
                eletrodomestico.getPrecoVenda(),
                eletrodomestico.getQuantidadeEstoque(),
                eletrodomestico.getMarca(),
                eletrodomestico.getModelo(),
                eletrodomestico.getCor(),
                eletrodomestico.getVoltagemSuportada(),
                eletrodomestico.getPotenciaWatts(),
                eletrodomestico.getPesoKG()
        );
        EletrodomesticosService.adicionarProdutoEletrodomestico(eletrodomestico);
        String mensagem = "produto cadastrado";
        return mensagem;
    }
    @GetMapping("buscarCodigo/{codigo}")
    public Eletrodomestico getBuscarCodigo(@PathVariable String codigo)throws SQLException {
        return buscarCodigo.buscarPorCodigoEletrodomestico(codigo);
    }
}
