package com.proferoberto.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "libros")
@Data
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    @Column(nullable = false)
    private String autor;

    @Min(value = 0, message = "El año no puede ser negativo")
    private Integer anioPublicacion;

    private String genero;

    @Min(0)
    private Integer stock;

    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal precio;

    // getters y setters (o usa Lombok @Data)
}