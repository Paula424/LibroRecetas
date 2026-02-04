package com.pauladp.LibroRecetas.Repositorios;

import com.pauladp.LibroRecetas.Entidades.MeGusta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeGustaRepositorio extends JpaRepository<MeGusta, Long> {

    List<MeGusta>findByRecetaId(Long recetaId);
}
