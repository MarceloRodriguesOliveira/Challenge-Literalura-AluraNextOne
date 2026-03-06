package com.alura.literalura;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InputReader {
    private final Scanner scanner = new Scanner(System.in);

    public String readString(){
        while (true){
            String input = scanner.nextLine().trim();

            if(!input.isEmpty()){
                return input;
            }

            System.out.println("Entrada inválida");
        }
    }

    public int readInt(){
        while (true){
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.println("Digite um número válido");
            }
        }
    }
}
