package org.example.exception;

public class ProdutoJaCadastradoException extends Exception {
    public ProdutoJaCadastradoException(String mensagem){
        super(mensagem);
    }
}
