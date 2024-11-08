package com.proyecto.SWL.Controlador;
import com.proyecto.SWL.DTO.EstadosDTO;
import com.proyecto.SWL.DTO.PaisesDTO;
import com.proyecto.SWL.Servicio.EstadosServicio;
import com.proyecto.SWL.Servicio.PaisesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Estados")
public class EstadosControlador {

    @Autowired
    private EstadosServicio estadosServicio;

    @GetMapping("/Verestados")
    public String Verestados (Model model){
        List<EstadosDTO> estados = estadosServicio.visualizarEstados();
        model.addAttribute("VisEstados", estados);
        return "Admin/Estados/estados";
    }

    @GetMapping("/NuevoEstados") //Visualizar formulario
    public String nuevosEstados(Model model) {
        EstadosDTO estadosDTO = new EstadosDTO();
        model.addAttribute("estadosVis", estadosDTO);
        return "Admin/Estados/NuevoEstados";
    }

    @PostMapping("/DatosNuevosEstados")
    public String datosNuevos(@ModelAttribute("estadosVis") EstadosDTO estadosDTO, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "Admin/Estados/NuevoEstados?Error";
        }
        estadosServicio.GuardarNuevoEstado(estadosDTO);
        return "redirect:/Estados/Verestados?Correcto";
    }

    @GetMapping("/EditarEstados/{id}")
    public String editarEstados(@PathVariable("id")Long id, Model model){
        EstadosDTO estadosDTO = estadosServicio.ObtenerEstadosId(id);
        model.addAttribute("editarEstados", estadosDTO);
        return "Admin/Estados/EditarEstados";
    }

    @PostMapping("/EditarEstadoFinal")
    public String EditarEstadoFinal(@ModelAttribute("editarEstados")EstadosDTO estadosDTO, BindingResult result, Model model){
        if (result.hasErrors()){
            return "Admin/Estados/EditarEstados?ErrorEstados";
        }if (estadosDTO.getIdEstado()==null){
            throw new IllegalArgumentException("No puede ser nulo");
        }
        estadosServicio.EditarEstados(estadosDTO);
        return "redirect:/Estados/Verestados?EditarCorrecto";
    }

}
