package com.alura.literalura.components;

import com.alura.literalura.Menu.OperationsMenu;
import com.alura.literalura.service.BookService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class MainMenuComponent {
    private final Scanner scanner = new Scanner(System.in);
    private final BookService bookService;
    private final OperationsMenu menu;

    public MainMenuComponent(BookService bookService, OperationsMenu menu){
        this.bookService = bookService;
        this.menu = menu;
    }

    public void getMenu() throws IOException, InterruptedException {
       int menuOption = -1;
       while (menuOption != 0){
           menu.options();
           menuOption = Integer.parseInt(scanner.nextLine());

           switch (menuOption){
               case 1 -> {bookService.findByTitle(); break;}
               default -> {
                   System.out.println("Sem outras operações por enquanto...");
               }

           }


        }
    }
}
