package org.example.service.controller;

import org.example.exception.NomeJaCadastrado;
import org.example.exception.ProdutoJaCadastradoException;
import org.example.model.Eletronicos;
import org.example.model.Produto;
import org.example.model.Vestuario;
import org.example.service.EletronicoService;
import org.example.service.VestuarioService;

import org.example.service.buscarCodigo.BuscarCodigo;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/produtoVestuario")
public class VestuarioController {
    private final BuscarCodigo buscarCodigo =  new BuscarCodigo();

    @PostMapping("/cadastro")
    public String cadastrarProduto(@RequestBody Vestuario requestVestuario) throws NomeJaCadastrado, SQLException, ProdutoJaCadastradoException {
        Vestuario produto_vestuario = new Vestuario(
                requestVestuario.getCodigo(),
                requestVestuario.getNome(),
                requestVestuario.getPrecoCusto(),
                requestVestuario.getPrecoVenda(),
                requestVestuario.getQuantidadeEstoque(),
                requestVestuario.getTamanho(),
                requestVestuario.getCor(),
                requestVestuario.getTecido()
        );
        VestuarioService.adicionarProdutoVestuario(produto_vestuario);
        String mensagem = "produto cadastrado";
        return mensagem;
    }


//
//    @DeleteMapping("/apagar/{codigo}")
//    public String deleterProdutoVestuario(@PathVariable String codigo) throws SQLException {
//        .apagarProdutoPorCodigo(codigo);
//        String mensagem = "produto deletado: " + codigo;
//        return mensagem;
//    }
//
    @GetMapping("/buscarCodigo/{codigo}")
    public Produto buscarProdutoPorCodigo(@PathVariable String codigo) throws SQLException {
        return buscarCodigo.buscarPorCodigoVestuario(codigo);

    }
//
//    @GetMapping("/listar")
//    public List<Produto> listarProduto() throws SQLException {
//        return estoqueService.buscarTodosProdutos();
//    }
//
// /*   @PutMapping("/atualizar/{codigo}")
//    public Produto atualizarProduto(@PathVariable String codigo, @RequestBody ProdutoRequest produtoRequest) throws SQLException {
//        Produto produtoexistente = estoqueService.buscarPorCodigo(codigo);
//        if (produtoexistente == null) {
//            return null;
//        }
//        estoqueService.atualizarNome(produtoRequest.getNome(), codigo);
//        estoqueService.atualizarPrecoCusto(produtoRequest.getPrecoCusto(), codigo);
//        estoqueService.atualizarPrecoVenda(produtoRequest.getPrecoVenda(), codigo);
//        estoqueService.atualizarQtdEstoque(produtoRequest.getQuantidadeEstoque(), codigo);
//        return estoqueService.buscarPorCodigo(codigo);
//    }*/
//
//    @GetMapping("/valorEstoque")
//    public int verValorEstoque() throws SQLException {
//        return estoqueService.valortotalestoque();
//    }
//
//    @GetMapping("/verProduto/{codigo}")
//    public Produto verProdutoPorCodigo(@PathVariable String codigo) throws SQLException {
//        return estoqueService.buscarPorCodigo(codigo);
//    }
}
