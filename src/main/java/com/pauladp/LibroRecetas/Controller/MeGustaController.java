package com.pauladp.LibroRecetas.Controller;

import com.pauladp.LibroRecetas.Entidades.MeGusta;
import com.pauladp.LibroRecetas.Service.MegustaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recetas/{recetaId}/me-gusta")
@CrossOrigin(origins = "*")
public class MeGustaController {

    @Autowired
    private MegustaServicio megustaServicio;

    @PostMapping
    public MeGusta crearMeGusta(
            @PathVariable Long recetaId,
            @RequestBody MeGusta meGusta){
        return megustaServicio.guardarMeGusta(recetaId, meGusta);
    }

    @GetMapping
    public List<MeGusta> listarMeGustas(@PathVariable Long recetaId){
        return megustaServicio.listarPorReceta(recetaId);
    }

    @DeleteMapping("/{id}")
    public void eliminarMeGusta(@PathVariable Long idMeGusta){
        megustaServicio.eliminarMeGusta(idMeGusta);
    }
}
