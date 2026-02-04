package com.pauladp.LibroRecetas.controller;

import com.pauladp.LibroRecetas.entidades.Receta;
import com.pauladp.LibroRecetas.service.RecetaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recetas")
@CrossOrigin(origins = "*") // Permite llamadas desde React
public class RecetaController {

    @Autowired
    private RecetaServicio recetaServicio;

    // Listar todas las recetas
    @GetMapping
    public List<Receta> listarRecetas() {
        return recetaServicio.listarRecetas();
    }

    // Obtener receta por id
    @GetMapping("/{id}")
    public ResponseEntity<Receta> obtenerReceta(@PathVariable Long id) {
        return recetaServicio.obtenerReceta(id)
                .map(receta -> ResponseEntity.ok().body(receta))
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nueva receta
    @PostMapping
    public Receta crearReceta(@RequestBody Receta receta) {
        return recetaServicio.guardarReceta(receta);
    }

    // Actualizar receta
    @PutMapping("/{id}")
    public ResponseEntity<Receta> actualizarReceta(@PathVariable Long id, @RequestBody Receta recetaDetalles) {
        return recetaServicio.obtenerReceta(id)
                .map(receta -> {
                    receta.setNombre(recetaDetalles.getNombre());
                    receta.setIngredientes(recetaDetalles.getIngredientes());
                    receta.setPasos(recetaDetalles.getPasos());
                    receta.setTiempoPreparacion(recetaDetalles.getTiempoPreparacion());
                    receta.setDificultad(recetaDetalles.getDificultad());
                    receta.setFotoURL(recetaDetalles.getFotoURL());
                    Receta recetaActualizada = recetaServicio.guardarReceta(receta);
                    return ResponseEntity.ok().body(recetaActualizada);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar receta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReceta(@PathVariable Long id) {
        return recetaServicio.obtenerReceta(id)
                .map(receta -> {
                    recetaServicio.eliminarReceta(id);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
