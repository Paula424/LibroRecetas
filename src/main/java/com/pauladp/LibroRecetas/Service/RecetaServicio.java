package com.pauladp.LibroRecetas.Service;


import com.pauladp.LibroRecetas.Entidades.Receta;
import com.pauladp.LibroRecetas.Repositorios.RecetaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaServicio {

    @Autowired
    private RecetaRepositorio recetaRepositorio;

    //Listar todas las recetas
    public List<Receta> listarRecetas(){
        return recetaRepositorio.findAll();
    }

    //Obtener receta por id
    public Optional<Receta> obtenerReceta(Long id){
        return recetaRepositorio.findById(id);
    }

    //Crear o actualizar receta
    public Receta guardarReceta(Receta receta){
        return recetaRepositorio.save(receta);
    }

    //Eliminar receta
    public void eliminarReceta(Long id){
        recetaRepositorio.deleteById(id);
    }

}
