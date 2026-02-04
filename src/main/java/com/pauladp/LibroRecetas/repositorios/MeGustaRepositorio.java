package com.pauladp.LibroRecetas.repositorios;

import com.pauladp.LibroRecetas.entidades.MeGusta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeGustaRepositorio extends JpaRepository<MeGusta, Long> {

    @Query("SELECT m FROM MeGusta m WHERE m.receta.id = :recetaId")
    List<MeGusta> buscarPorRecetaId(@Param("recetaId") Long recetaId);
}

