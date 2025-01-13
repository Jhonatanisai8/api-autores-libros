package org.api.api_autores_libros.services;

import java.util.List;

import org.api.api_autores_libros.model.Author;
import org.api.api_autores_libros.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public List<Author> getAllAuthors() {
        return repository.findAll();
    }

    public Author geAuthorById(Long idAuthor) {
        return getAllAuthors()
                .stream()
                .filter(author -> author.getAuthor_id().equals(idAuthor))
                .findFirst()
                .map(authorBus -> {
                    return authorBus;
                }).orElseThrow(() -> new EntityNotFoundException("Autor con no encontrado con ID: " + idAuthor));
    }
}
