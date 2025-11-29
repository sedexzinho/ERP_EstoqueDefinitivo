package org.example;

import org.example.model.Produto;
import org.example.service.EstoqueService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        EstoqueService estoqueService = new EstoqueService();
            while (true) {
                String codigo;
                String nome;
                double custoCompra;
                double custoVenda;
                int quantidadeEstoque;
                System.out.println("Digite o codigo (ou 'pare') para encerrar");
                codigo = scanner.next();

                if (codigo.equals("pare")) {
                    if (estoqueService.verificaListaVazia()) {
                        System.err.println("Cadastre pelo menos um produto");
                        continue;
                    }
                    break;
                }

                if (estoqueService.buscarPorCodigo(codigo) != null) {
                    System.err.println("O codigo ja existe, tente outro");
                    continue;
                }
                System.out.println("Nome do produto: ");
                nome = scanner.next();
                if (estoqueService.buscarPorNome(nome) != null) {
                    System.err.println("O nome ja existe, tente outro");
                    continue;
                }
                System.out.println("Valor de compra:");
                custoCompra = scanner.nextDouble();
                do {
                    System.out.println("Valor de venda:");
                    custoVenda = scanner.nextDouble();
                    if (custoVenda < custoCompra) {
                        System.err.println("O valor de venda NÃO pode ser menor que o de compra. Tente novamente.");
                    }
                } while (custoVenda < custoCompra);

                System.out.println("Quantidade de Estoque do produto: ");
                quantidadeEstoque = scanner.nextInt();

                if (quantidadeEstoque < 0 || quantidadeEstoque > 100001) {
                    System.out.println("Quantidade invalida, digite um numero entre 1 e 100.000");
                    continue;
                }
                scanner.nextLine();
                Produto produto = new Produto(codigo, nome, custoCompra, custoVenda, quantidadeEstoque);
                try {
                    estoqueService.adicionarProduto(produto);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }



}





