package com.proyecto.SWL.Controlador;

import com.proyecto.SWL.DTO.EstadosDTO;
import com.proyecto.SWL.DTO.PaisesDTO;
import com.proyecto.SWL.DTO.TipoDocumentosDTO;
import com.proyecto.SWL.Modelo.TipoDocumentos;
import com.proyecto.SWL.Servicio.EstadosServicio;
import com.proyecto.SWL.Servicio.TipoDocumentosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/TipoDocumento")
public class TipoDocumentosControlador {

    @Autowired// Inyectar dependencia o los servicios
    private TipoDocumentosServicio tipoDocumentoSer;
    @Autowired
    private EstadosServicio estadosServicio;

    @GetMapping("/verDocumentos")//get Mapping Acceder a una URL
    public String verDocumentos(Model model){
        List<TipoDocumentosDTO>  tipoDocumentos = tipoDocumentoSer.visualizarDocumentos();
        model.addAttribute("VisDocumentos",tipoDocumentos);
        return "Admin/TipoDocumentos/TipoDocumento";
    }

    @GetMapping("/NuevoDocumento")
    public String nuevoDocumento(Model model){
        TipoDocumentosDTO tipoDocumentosDTO = new TipoDocumentosDTO();
        model.addAttribute("NuevoDocumento" , tipoDocumentosDTO);
        return "Admin/TipoDocumentos/NuevoTipoDocumento";
    }

    @PostMapping("/DatosNuevosDocumentos")
    public String datosNuevosDocumentos(@ModelAttribute("NuevoDocumento") TipoDocumentosDTO tipoDocumentosDTO, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "Admin/TipoDocumentos/NuevoTipoDocumento?Error";
        }
        tipoDocumentoSer.GuardarNuevoDocumento(tipoDocumentosDTO);
        return "redirect:/TipoDocumento/verDocumentos?Correcto";
    }

    @GetMapping("/EditarDocumento/{id}")
    public String Documento(@PathVariable("id")Long id, Model model){
        TipoDocumentosDTO tipoDocumentosDTO = tipoDocumentoSer.ObtenerDocumentoId(id);
        model.addAttribute("editarDocumentos",tipoDocumentosDTO);
        List<EstadosDTO> estadosDTO = estadosServicio.visualizarEstados();
        model.addAttribute("estados" , estadosDTO);
        return "Admin/TipoDocumentos/EditarTipoDocumento";
    }

    @PostMapping("/EditarDocumentoFinal")
    public String EditarDocumentoFinal(@ModelAttribute("editarDocumentos")TipoDocumentosDTO tipoDocumentosDTO, BindingResult result, Model model){
        if (result.hasErrors()){
            return "Admin/TipoDocumentos/EditarTipoDocumento?ErrorDocumento";
        }if (tipoDocumentosDTO.getIdDocumento()==null){
            throw new IllegalArgumentException("No puede ser nulo");
        }
       tipoDocumentoSer.EditarDDocumento(tipoDocumentosDTO);
        return "redirect:/TipoDocumento/verDocumentos?CorrectoE";
    }





}
