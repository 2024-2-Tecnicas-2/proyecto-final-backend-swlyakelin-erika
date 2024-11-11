package com.proyecto.SWL.Controlador;


import com.proyecto.SWL.DTO.PaisesDTO;
import com.proyecto.SWL.Servicio.PaisesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;

@Controller
public class PaisesControlador {

    @Autowired
    private PaisesServicio paisesSer;

    @GetMapping("/paises") // Visualizar Datos
    public String paises(Model model) {
        List<PaisesDTO> paises = paisesSer.visualizar();
        model.addAttribute("VisPaises", paises);
        return "Admin/Paises/paises";
    }

    @GetMapping("/NuevoPaises") //Visualizar formulario
    public String nuevosPaises(Model model) {
        PaisesDTO paisesDTO = new PaisesDTO();
        model.addAttribute("PaisesVis", paisesDTO);
        return "Admin/Paises/NuevoPaises";
    }

    @PostMapping("/DatosNuevosPaises")
    public String datosNuevos(@ModelAttribute("PaisesVis") PaisesDTO paisesDTO, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "Admin/Paises/NuevoPaises?Error";
        }
        paisesSer.GuardarNuevoPais(paisesDTO);
        return "redirect:/paises?Correcto";
    }

    @GetMapping("/EditarPais/{id}")
    public String editarPais(@PathVariable("id")Long id, Model model){
    PaisesDTO paisesDTO = paisesSer.ObtenerPaisId(id);
    model.addAttribute("editarPaises", paisesDTO);
    return "Admin/Paises/EditarPaises";
    }

    @PostMapping("/EditarPaisFinal")
    public String EditarPaisFinal(@ModelAttribute("editarPaises")PaisesDTO paisesDTO, BindingResult result, Model model){
        if (result.hasErrors()){
            return "Admin/Paises/EditarPaises?ErrorEditar";
        }if (paisesDTO.getIdPais()==null){
            throw new IllegalArgumentException("No puede ser nulo");
        }
        paisesSer.EditarPaises(paisesDTO);
    return "redirect:/paises?EditarCorrecto";
    }







}

