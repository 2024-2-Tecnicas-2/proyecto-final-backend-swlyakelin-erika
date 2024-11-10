package com.proyecto.SWL.Controlador;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // esta anotacion es para que en el sprint boot lo tome como controlador
public class AdminControlador {

    @GetMapping("/") // Para indicarle a que direccion ir
    public String dashBoard(){
        return "Admin/index";
    }


}
