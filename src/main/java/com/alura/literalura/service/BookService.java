package com.alura.literalura.service;

import com.alura.literalura.InputReader;
import com.alura.literalura.connection.ApiConnection;
import com.alura.literalura.dto.AuthorDto;
import com.alura.literalura.dto.BookDto;
import com.alura.literalura.dto.RequestDto;
import com.alura.literalura.dto.ResponseDto;
import com.alura.literalura.entity.Author;
import com.alura.literalura.entity.Book;
import com.alura.literalura.repository.AuthorRepository;
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
    //private final Scanner SCANNER = new Scanner(System.in);
    private final AuthorRepository authorRepository;
    private final InputReader inputReader;

    public void printBook(Book book){
        System.out.println("--- LIVRO ---");
        System.out.println("Titulo: " + book.getTitle());
        System.out.println("Autor: " + book.getAuthor().getName());
        System.out.println("Idioma: " + book.getLanguage());
        System.out.println("Numero de downloads: " + book.getDownload_count());
        System.out.println();
    }

    public void printAuthor(Author author){
        System.out.println("--- AUTOR ---");
        System.out.println("Autor: " + author.getName());
        System.out.println("Ano de nascimento: " + author.getBirthYear());
        System.out.println("Ano de morte: " + author.getDeathYear());
        System.out.println("Livros: " + author.getBooks().get(0).getTitle());
        System.out.println();
    }

    public void findByTitleAndSave() throws IOException, InterruptedException {
        System.out.println("Insira o nome do livra que você deseja procurar");
        String title = inputReader.readString();

        RequestDto request = new RequestDto(title);

        ApiConnection connection = new ApiConnection();

        ResponseDto response = connection.response(request);

        if(response == null || response.results().isEmpty()){
            System.out.println("Livro  não encontrado");
            return;
        }

        BookDto bookDto = response.results().get(0);
        AuthorDto authorDto = bookDto.authors().get(0);

        Author author = authorRepository.findByName(authorDto.name())
                .orElseGet(()-> {
                    Author newAuthor = new Author(authorDto.name(), authorDto.birth_year(), authorDto.death_year());
                    return authorRepository.save(newAuthor);
                });

        Book book = new Book(bookDto.id(), bookDto.title(), bookDto.languages().get(0), bookDto.download_count(), author);

        printBook(book);

        if(bookRepository.findByTitle(bookDto.title()).isPresent()){
            System.out.println("Livro já registrado");
            return;
        }

        bookRepository.save(book);
    }

    public void listBooks(){
        List<Book> books = bookRepository.findAll();

        if(books.isEmpty()){
            System.out.println("Nenhum livro registrado...");
            return;
        }

        books.forEach(this::printBook);
    }

    public void listAuthors(){
        List<Author> authors = authorRepository.findAll();

        if(authors.isEmpty()){
            System.out.println("Sem autores registrados...");
            return;
        }

        authors.forEach(this::printAuthor);
    }

    public void listByActivityInYear(){
        System.out.println("Insira o ano que deseja pesquisar");
        Integer year = inputReader.readInt();

        List<Author> authors = authorRepository.findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(year, year);

        if(authors.isEmpty()){
            System.out.println("Nenhum autor encontrado vivo nesse ano.");
            return;
        }

        authors.forEach(this::printAuthor);
    }

    public void listByLanguage(){
        System.out.println("Insira o idioma para realizar a busca:");
        System.out.println("es - espanhol");
        System.out.println("en - inglês");
        System.out.println("fr - francês");
        System.out.println("pt - português");

        String languageCode = inputReader.readString();

        List<Book> books = bookRepository.findByLanguage(languageCode);

        if(books.isEmpty()){
            System.out.println("Sem livros registrados com esse idioma");
            return;
        }

        books.forEach(this::printBook);
    }



}
