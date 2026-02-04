package com.pauladp.LibroRecetas.service;

import com.pauladp.LibroRecetas.entidades.MeGusta;
import com.pauladp.LibroRecetas.entidades.Receta;
import com.pauladp.LibroRecetas.repositorios.MeGustaRepositorio;
import com.pauladp.LibroRecetas.repositorios.RecetaRepositorio;
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
        return meGustaRepositorio.buscarPorRecetaId(recetaId);    }

    public void eliminarMeGusta(Long idMeGusta){
        meGustaRepositorio.deleteById(idMeGusta);
    }

}
