package org.example;

import org.example.infrastructure.ConexaoBD;
import org.example.model.Alimenticio;
import org.example.model.Produto;
import org.springframework.boot.SpringApplication;

import java.sql.SQLException;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(SpringBootApplication.class, args);
        ConexaoBD conexaoBD = new ConexaoBD();
        ConexaoBD.inicializarBanco();
    }
}
