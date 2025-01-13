package org.api.api_autores_libros.repository;

import org.api.api_autores_libros.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository
extends JpaRepository<Book,Long> {

}
