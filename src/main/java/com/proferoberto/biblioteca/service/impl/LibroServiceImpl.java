package com.proferoberto.biblioteca.service.impl;

import com.proferoberto.biblioteca.exception.NotFoundException;
import com.proferoberto.biblioteca.model.Libro;
import com.proferoberto.biblioteca.repository.LibroRepository;
import com.proferoberto.biblioteca.service.LibroService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LibroServiceImpl implements LibroService {

    private final LibroRepository repo;

    public LibroServiceImpl(LibroRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Libro> listar() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Libro buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Libro no encontrado: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Libro> buscarPorTitulo(String q) {
        return repo.findByTituloContainingIgnoreCase(q);
    }

    @Override
    public Libro crear(Libro libro) {
        return repo.save(libro);
    }

    @Override
    public Libro actualizar(Long id, Libro libro) {
        Libro actual = buscarPorId(id);
        actual.setTitulo(libro.getTitulo());
        actual.setAutor(libro.getAutor());
        actual.setAnioPublicacion(libro.getAnioPublicacion());
        actual.setGenero(libro.getGenero());
        actual.setStock(libro.getStock());
        actual.setPrecio(libro.getPrecio());
        return repo.save(actual);
    }

    @Override
    public void eliminar(Long id) {
        Libro actual = buscarPorId(id);
        repo.delete(actual);
    }
}
