package org.api.api_autores_libros.services;

import java.util.List;

import org.api.api_autores_libros.model.Book;
import org.api.api_autores_libros.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

}
