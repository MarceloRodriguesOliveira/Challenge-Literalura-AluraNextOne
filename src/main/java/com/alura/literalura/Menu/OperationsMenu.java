package com.alura.literalura.Menu;

import org.springframework.stereotype.Component;

@Component
public class OperationsMenu implements Menu{

    @Override
    public void options() {
        System.out.println("---------");
        System.out.println("1 - buscar livro pelo título");
        System.out.println("2 - listar livros registrados");
        System.out.println("3 - listar autores registrados");
        System.out.println("4 - listar autores vivos em um determinado ano");
        System.out.println("5 - listar livros em um determinado idioma");
        System.out.println("0 - sair");
        System.out.println(" ");
        System.out.println("---------");
    }
}
