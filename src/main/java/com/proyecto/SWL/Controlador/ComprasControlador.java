package com.proyecto.SWL.Controlador;
import com.proyecto.SWL.DTO.ComprasDTO;
import com.proyecto.SWL.Servicio.ComprasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Compras")
public class ComprasControlador {

    @Autowired
    private ComprasServicio comprasServicio;

    @GetMapping("/Vercompras")
    public String Vercompras (Model model){
        List<ComprasDTO> compras = comprasServicio.visualizarVenta();
        model.addAttribute("VisCompras", compras);
        return "Admin/Compras/compras";
    }

    @GetMapping("/NuevaCompra") //Visualizar formulario
    public String nuevasCompras(Model model) {
        ComprasDTO comprasDTO = new ComprasDTO();
        model.addAttribute("comprasVis", comprasDTO);
        return "Admin/Compras/NuevasCompras";
    }

    @PostMapping("/DatosNuevasCompras")
    public String datosNuevos(@ModelAttribute("comprasVis") ComprasDTO comprasDTO, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "Admin/Compras/NuevaCompra?Error";
        }
        comprasServicio.GuardarNuevaCompra(comprasDTO);
        return "redirect:/Compras/Vercompras?Correcto";
    }

    @GetMapping("/EditarCompras/{id}")
    public String editarCompras(@PathVariable("id")Long id, Model model){
        ComprasDTO comprasDTO = comprasServicio.ObtenerCompraId(id);
        model.addAttribute("editarCompras", comprasDTO);
        return "Admin/Compras/EditarCompras";
    }

    @PostMapping("/EditarComprasFinal")
    public String EditarComprasFinal(@ModelAttribute("editarCompras")ComprasDTO comprasDTO, BindingResult result, Model model){
        if (result.hasErrors()){
            return "Admin/Compras/EditarCompras?ErrorEstados";
        }if (comprasDTO.getIdVenta()==null){
            throw new IllegalArgumentException("No puede ser nulo");
        }
        comprasServicio.EditarCompra(comprasDTO);
        return "redirect:/Compras/Vercompras?EditarCorrecto";
    }

}
