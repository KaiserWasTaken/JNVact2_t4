package com.web.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.web.demo.models.dto.LibroDTO;

@Controller
@RequestMapping("/libros")
public class LibrosController {
    private final List<LibroDTO> libros = new ArrayList<>(List.of(
            new LibroDTO(1, "Cien anos de soledad", "Gabriel Garcia Marquez", "Novela", 299.90),
            new LibroDTO(2, "Sapiens", "Yuval Noah Harari", "Historia", 349.50),
            new LibroDTO(3, "Clean Code", "Robert C. Martin", "Tecnologia", 599.00)));

    @Value("${catalogo.nombre}")
    private String nombreCatalogo;

    @GetMapping
    public String listar(
            @RequestParam(required = false) String categoria,
            Model model) {
        List<LibroDTO> resultados = libros;

        if (categoria != null && !categoria.isBlank()) {
            resultados = libros.stream()
                    .filter(libro -> libro.getCategoria().equalsIgnoreCase(categoria.trim()))
                    .toList();
        }

        model.addAttribute("libros", resultados);
        model.addAttribute("categoriaActual", categoria == null ? "" : categoria);
        model.addAttribute("nombreCatalogo", nombreCatalogo);
        return "libros/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("libro", new LibroDTO());
        model.addAttribute("nombreCatalogo", nombreCatalogo);
        return "libros/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute("libro") LibroDTO libro) {
        libro.setId(siguienteId());
        libros.add(libro);
        return "redirect:/libros";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable int id, Model model) {
        LibroDTO libro = libros.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "No existe el libro con id " + id));

        model.addAttribute("libro", libro);
        model.addAttribute("nombreCatalogo", nombreCatalogo);
        return "libros/detalle";
    }

    private int siguienteId() {
        return libros.stream()
                .mapToInt(LibroDTO::getId)
                .max()
                .orElse(0) + 1;
    }
}
