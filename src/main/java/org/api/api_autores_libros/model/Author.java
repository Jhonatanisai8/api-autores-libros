package org.api.api_autores_libros.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "autor")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    private String nationality;
    private Date birthDate;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Book> libros = new ArrayList<>();

}
