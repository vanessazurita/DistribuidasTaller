package com.espe.cursos.controllers;

import com.espe.cursos.models.entities.Evento;
import com.espe.cursos.services.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    // Crear un nuevo evento
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Evento evento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(evento));
    }

    // Obtener todos los eventos
    @GetMapping
    public ResponseEntity<List<Evento>> obtenerTodos() {
        List<Evento> eventos = service.findAll();
        return ResponseEntity.ok(eventos);
    }

    // Obtener un evento por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Evento> obtenerPorId(@PathVariable Integer id) {
        Optional<Evento> evento = service.findById(id);
        return evento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Eliminar un evento por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        Optional<Evento> evento = service.findById(id);
        if (evento.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento no encontrado");
        }
    }

    // Manejo de errores de validación
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errores.put(error.getField(), error.getDefaultMessage()));
        return errores;
    }
}
