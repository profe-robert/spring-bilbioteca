package com.proferoberto.biblioteca.repository;

import com.proferoberto.biblioteca.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    boolean existsByIsbn(String isbn);
}
