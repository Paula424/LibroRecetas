package com.pauladp.LibroRecetas.Service;

import com.pauladp.LibroRecetas.Entidades.MeGusta;
import com.pauladp.LibroRecetas.Entidades.Receta;
import com.pauladp.LibroRecetas.Repositorios.MeGustaRepositorio;
import com.pauladp.LibroRecetas.Repositorios.RecetaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MegustaServicio {
    @Autowired
    private MeGustaRepositorio meGustaRepositorio;

    @Autowired
    private RecetaRepositorio recetaRepositorio;

    public MeGusta guardarMeGusta(Long recetaId, MeGusta meGusta){
        Receta receta = recetaRepositorio.findById(recetaId).orElseThrow();
                meGusta.setReceta(receta);
                return meGustaRepositorio.save(meGusta);
    }

    public List<MeGusta>listarPorReceta(Long recetaId){
        return meGustaRepositorio.findByReceta_Id(recetaId);
    }

    public void eliminarMeGusta(Long idMeGusta){
        meGustaRepositorio.deleteById(idMeGusta);
    }

}
