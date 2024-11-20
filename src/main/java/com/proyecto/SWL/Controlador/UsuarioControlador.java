package com.proyecto.SWL.Controlador;

import com.proyecto.SWL.DTO.*;
import com.proyecto.SWL.Servicio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UsuarioControlador {

    @Autowired// Inyectar dependencia o los servicios
    private UsuariosServicio usuariosServicio;
    @Autowired
    private EstadosServicio estadosServicio;
    @Autowired
    private TipoDocumentosServicio tipoDocumentosServicio;
    @Autowired
    private PaisesServicio paisesServicio;
    @Autowired
    private RolesServicio rolesServicio;

    @GetMapping("/verUsuarios")//get Mapping Acceder a una URL
    public String verUsuario(Model model){
        List<UsuarioDTO> usuarios = usuariosServicio.visualizarUsuarios();
        model.addAttribute("VisUsuarios",usuarios);
        return "Admin/Usuarios/Usuario";
    }

    @GetMapping("/NuevoUsuario")
    public String nuevoUsuario(Model model){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        model.addAttribute("NuevoUsuario" , usuarioDTO);

        List<EstadosDTO> estadosDTO = estadosServicio.visualizarEstados();
        model.addAttribute("estados" , estadosDTO);

        List<TipoDocumentosDTO> tipoDocumentosDTOS = tipoDocumentosServicio.visualizarDocumentos();
        model.addAttribute("documentos" , tipoDocumentosDTOS);

        List<RolesDTO> rolesDTOS = rolesServicio.visualizar();
        model.addAttribute("roles" , rolesDTOS);

        List<PaisesDTO> paisesDTOS = paisesServicio.visualizar();
        model.addAttribute("paises" , paisesDTOS);
        return "Admin/Usuarios/NuevoUsuario";
    }

    @PostMapping("/DatosNuevosUsuarios")
    public String datosNuevosUsuario(@ModelAttribute("NuevoUsuario") UsuarioDTO usuarioDTO, BindingResult result, Model model) {
        if (result.hasErrors()){
            return "Admin/user/NuevoUsuario?ErrorUsuario";
        }
        usuariosServicio.GuardarNuevoUsuario(usuarioDTO);
        return "redirect:/user/verUsuarios?CorrectoUusario";
    }

    @GetMapping("/EditarUsuario/{id}")
    public String usuariOO(@PathVariable("id")Long id, Model model){
        UsuarioDTO usuarioDTO = usuariosServicio.ObtenerUsuarioId(id);
        model.addAttribute("editarUsuarios",usuarioDTO);
        List<TipoDocumentosDTO> tipoDocumentosDTOS = tipoDocumentosServicio.visualizarDocumentos();
        model.addAttribute("documentos" , tipoDocumentosDTOS);
        List<RolesDTO> rolesDTOS = rolesServicio.visualizar();
        model.addAttribute("roles" , rolesDTOS);
        List<PaisesDTO> paisesDTOS = paisesServicio.visualizar();
        model.addAttribute("paises" , paisesDTOS);
        return "Admin/Usuarios/EditarUsuario";
    }

    @PostMapping("/EditarUsuarioFinal")
    public String EditarUsuarioFinal(@ModelAttribute("editarUsuarios")UsuarioDTO usuarioDTO, BindingResult result, Model model){
        
        if (result.hasErrors()){
            System.out.println("FALLADO");
            result.getFieldErrors().forEach(error -> {
                System.out.println("Campo: " + error.getField() +
                        ", Mensaje: " + error.getDefaultMessage() +
                        ", Valor rechazado: " + error.getRejectedValue());
            });
            return "redirect:/user/verUsuarios?ErrorEditUsuario";
        }if (usuarioDTO.getIdUsuario()==null){
            throw new IllegalArgumentException("No puede ser nulo  id usuario");
        }
        usuariosServicio.EditarUsuario(usuarioDTO);
        return "redirect:/user/verUsuarios?CorrectoU";
    }

}
