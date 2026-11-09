package com.web.demo.controllers;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.demo.models.dto.LibroDTO;

@RestController
@RequestMapping("/api/libros")
public class LibrosRestController {
    private final AtomicInteger siguienteId = new AtomicInteger(100);

    @PostMapping
    public LibroDTO crear(@RequestBody LibroDTO libro) {
        if (libro.getId() == null || libro.getId() <= 0) {
            libro.setId(siguienteId.getAndIncrement());
        }
        return libro;
    }
}
