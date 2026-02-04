package com.pauladp.LibroRecetas.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Entity
@Table(name = "recetas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String ingredientes;

    private String pasos;

    private Integer tiempoPreparacion;

    @Enumerated(EnumType.STRING)
    private Dificultad dificultad;

    public enum Dificultad{
        FACIL,
        MEDIA,
        DIFICIL
    }

    private String fotoURL;

}
