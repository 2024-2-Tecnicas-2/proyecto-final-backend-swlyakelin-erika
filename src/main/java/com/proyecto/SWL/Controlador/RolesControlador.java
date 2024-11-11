package com.proyecto.SWL.Controlador;
import com.proyecto.SWL.DTO.RolesDTO;
import com.proyecto.SWL.Servicio.RolesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Roles")
public class RolesControlador {

    @Autowired
    private RolesServicio rolesServicio;

    @GetMapping("/roles")
    public String roles (Model model){
        List<RolesDTO> roles = rolesServicio.visualizar();
        model.addAttribute("VisRoles", roles);
        return "Admin/Roles/roles";
    }

    @GetMapping("/NuevoRol") //Visualizar formulario
    public String nuevosRoles (Model model) {
        RolesDTO rolesDTO = new RolesDTO();
        model.addAttribute("rolesVis", rolesDTO);
        return "Admin/Roles/NuevoRol";
    }

    @PostMapping("/DatosNuevosRoles")
    public String datosNuevos(@ModelAttribute("rolesVis") RolesDTO rolesDTO, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "Admin/Roles/NuevoRol?Error";
        }
        rolesServicio.GuardarNuevoRol(rolesDTO);
        return "redirect:/Roles/roles?CorrectoRoles";
    }

    @GetMapping("/EditarRoles/{id}")
    public String editarRoles(@PathVariable("id")Long id, Model model){
        RolesDTO rolesDTO = rolesServicio.ObtenerRolId(id);
        model.addAttribute("editarRoles", rolesDTO);
        return "Admin/Roles/EditarRoles";
    }

    @PostMapping("/EditarRolFinal")
    public String EditarRolFinal(@ModelAttribute("editarRoles")RolesDTO rolesDTO, BindingResult result, Model model){
        if (result.hasErrors()){
            return "Admin/Roles/EditarRoles?ErrorRoles";
        }if (rolesDTO.getIdRol()==null){
            throw new IllegalArgumentException("No puede ser nulo");
        }
        rolesServicio.EditarRoles(rolesDTO);
        return "redirect:/Roles/roles?EditarRolCorrecto";
    }

}
