package com.alura.literalura.service;

import com.alura.literalura.entity.Book;
import com.alura.literalura.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

}
