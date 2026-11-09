package com.web.demo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.demo.models.Empleados;
import com.web.demo.models.dto.ClaseDTO;

@RestController 
@RequestMapping("/api")

public class EjemploRestController {

    @RequestMapping(path = "/detalles_info2")

    public ClaseDTO detalles_info() {
        
        /*Empleados empleado1 = new Empleados("Juan", "Perez", "Gerente", "Calle 123", 
        35, 5551234, 001);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("Empleado", "Datos Empleado");
        respuesta.put("Empleado", empleado1);*/
        
        ClaseDTO usuario1 = new ClaseDTO();
        usuario1.setTitulo("Administrador");
        usuario1.setUsuario("23161054");
        
        return usuario1;
    }
    
}
