package com.web.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping ("/api/parametros")

public class RequestParamControllers {

    @GetMapping("/detalle")

    //http://localhost:9526/api/parametros/detalle?informacion=Saludos%20a%20todos%20jijiji
    public ParametroDTO detalle(@RequestParam (required = false , defaultValue = "No se proporciono informacion")String informacion){
        ParametroDTO parametro1 = new ParametroDTO();
        parametro1.setInformacion(informacion);
        return parametro1;
    }
    
}
