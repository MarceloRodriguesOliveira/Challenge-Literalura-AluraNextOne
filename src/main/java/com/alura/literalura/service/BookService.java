package com.alura.literalura.service;

import com.alura.literalura.connection.ApiConnection;
import com.alura.literalura.dto.AuthorDto;
import com.alura.literalura.dto.BookDto;
import com.alura.literalura.dto.RequestDto;
import com.alura.literalura.dto.ResponseDto;
import com.alura.literalura.entity.Author;
import com.alura.literalura.entity.Book;
import com.alura.literalura.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final Scanner SCANNER = new Scanner(System.in);

    public void findByTitle() throws IOException, InterruptedException {
        System.out.println("Insira o nome do livra que você deseja procurar");
        String title = SCANNER.nextLine();

        RequestDto request = new RequestDto(title);

        ApiConnection connection = new ApiConnection();

        ResponseDto response = connection.response(request);

        if(response == null || response.results().isEmpty()){
            System.out.println("Livro  não encontrado");
            return;
        }

        BookDto book = response.results().get(0);

        AuthorDto authorDto = book.authors().get(0);

        Author author = new Author(authorDto.name(), authorDto.birth_year(), authorDto.death_year());


        Book bookFromApi = new Book(book.id(), book.title(), book.languages().get(0), book.download_count(), author);

        System.out.println("--- LIVRO ---");
        System.out.println("Titulo: "+ bookFromApi.getTitle());
        System.out.println("Autor: "+bookFromApi.getAuthor().getName());
        System.out.println("Idioma: "+ bookFromApi.getLanguage());
        System.out.println("Numero de downloads: "+ bookFromApi.getDownload_count());

    }

}
