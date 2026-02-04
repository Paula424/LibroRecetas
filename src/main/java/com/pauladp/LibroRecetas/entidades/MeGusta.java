package com.pauladp.LibroRecetas.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "meGusta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeGusta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMeGusta;

    private String nombreUsuario;

    @ManyToOne
    @JoinColumn(name = "receta_id")
    private Receta receta;
}
