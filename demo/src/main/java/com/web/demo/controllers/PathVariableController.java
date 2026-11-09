package com.web.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.web.demo.models.Empleados;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


//http://localhost:9526/api/variable/pagina1/aaaaaaaaaa
@RestController 
@RequestMapping ("/api/variable")
public class PathVariableController {

    @Value ("${config.usuario}")
    private String usuario;

    @Value ("${config.codigo}")
    private int codigo;

    @Value ("${config.mensaje}")
    private String mensaje;

    @Value ("${config.valores}")
    private String[] valores;


    @GetMapping("/pagina1/{mensaje}")
    public ParametroDTO pagina1(@PathVariable String mensaje){

        ParametroDTO pagina1 = new ParametroDTO();
        pagina1.setInformacion(mensaje);
        return pagina1;

    }

    //localhost:9526/api/variable/solicitud
    /*
    {
    "nombre": "a",
    "apellido": "b",
    "puesto": "c",
    "direccion": "d",
    "edad": 21,
    "telefono": 87289342,
    "id": 2
    } 
    */
    @PostMapping("/solicitud")
    public Empleados crearEmpleado(@RequestBody Empleados empleado1){

        return empleado1;

    }

    //http://localhost:9526/api/variable/valores
    @GetMapping("/valores")
    public Map<String, Object> values() {
        Map<String, Object> json = new HashMap<>();
        json.put("usuario", usuario);
        json.put("codigo", codigo);
        json.put("mensaje", mensaje);
        json.put("valores", valores);
        return json;
    }
    
    
}
