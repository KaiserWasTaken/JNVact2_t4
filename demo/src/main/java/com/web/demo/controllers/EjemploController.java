package com.web.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.demo.models.Empleados;

@Controller 
public class EjemploController {

    @GetMapping("/detalles_info")

    //http://localhost:9526/detalles_info
    public String info(Model model) {
        
        Empleados empleado1 = new Empleados("Juan", "Perez", "Gerente", null, 
        35, 5551234, 001);
        model.addAttribute("Empleado", empleado1);

        return "detalles_info";
    }

    @ModelAttribute("empleados")
    public List<Empleados> ListaEmpleados() {
        return Arrays.asList(
            new Empleados("Juan", "Perez", "Gerente", null, 35, 5551234, 001),
            new Empleados("Maria", "Gonzalez", "Supervisora", "su casa", 30, 5551235, 002),
            new Empleados("Pedro", "Rodriguez", "Empleado", null, 28, 5551236, 003)
        );
    }

}
