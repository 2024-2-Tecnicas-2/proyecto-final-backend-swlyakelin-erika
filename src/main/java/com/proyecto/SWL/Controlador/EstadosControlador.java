package com.proyecto.SWL.Controlador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Estados")
public class EstadosControlador {

    @GetMapping("/Verestados")
    public String Verestados (){
        return "Admin/Estados/estados";
    }

}
