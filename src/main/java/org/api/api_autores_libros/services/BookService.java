package org.api.api_autores_libros.services;

import java.util.List;
import java.util.Optional;

import org.api.api_autores_libros.model.Author;
import org.api.api_autores_libros.model.Book;
import org.api.api_autores_libros.repository.AuthorRepository;
import org.api.api_autores_libros.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book saveBook(Book request) {
        Optional<Author> authorSearch = authorRepository
                .findById(request.getAutor().getAuthor_id());
        if (!authorSearch.isPresent()) {
            throw new EntityNotFoundException("Autor no encontrado con Id: " + request.getAutor()
                    .getAuthor_id());
        }
        request.setAutor(authorSearch.get());
        return repository.save(request);
    }

}
