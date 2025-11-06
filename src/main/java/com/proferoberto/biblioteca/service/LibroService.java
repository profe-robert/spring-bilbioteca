package com.proferoberto.biblioteca.service;

import com.proferoberto.biblioteca.model.Libro;
import java.util.List;

public interface LibroService {
    List<Libro> listar();
    Libro buscarPorId(Long id);
    List<Libro> buscarPorTitulo(String q);
    Libro crear(Libro libro);
    Libro actualizar(Long id, Libro libro);
    void eliminar(Long id);
}
