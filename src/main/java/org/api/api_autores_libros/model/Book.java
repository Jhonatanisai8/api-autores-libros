package org.api.api_autores_libros.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {
    // id
    // titulo
    // genero
    // aniopublicacion
    // autor

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    @NotNull
    private String tittle;
    private String gender;
    private Integer yearPublication;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Author author;

}
