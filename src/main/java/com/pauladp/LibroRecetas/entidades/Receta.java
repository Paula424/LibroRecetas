package com.pauladp.LibroRecetas.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "recetas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceta;

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


    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MeGusta> meGustas;

}
