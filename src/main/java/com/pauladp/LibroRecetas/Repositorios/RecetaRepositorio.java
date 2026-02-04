package com.pauladp.LibroRecetas.Repositorios;

import com.pauladp.LibroRecetas.Entidades.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepositorio extends JpaRepository<Receta, Long> {
}
