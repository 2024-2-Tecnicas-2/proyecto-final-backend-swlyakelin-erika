package com.proyecto.SWL.Servicio;

import com.proyecto.SWL.DTO.TipoDocumentosDTO;
import com.proyecto.SWL.DTO.UsuarioDTO;
import com.proyecto.SWL.Modelo.TipoDocumentos;
import com.proyecto.SWL.Modelo.Usuario;
import com.proyecto.SWL.Repositorio.IEstados;
import com.proyecto.SWL.Repositorio.ITipoDocumentos;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UsuariosServicio {

    @Autowired
    private ITipoDocumentos iTipoDocumentos;
    @Autowired
    private IEstados iEstados;

    private UsuarioDTO trasnforDTO(Usuario  usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(usuario.getIdUsuario());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setContrasena(usuario.getContrasena());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioDTO.setNumeroDocumento(usuario.getNumeroDocumento());
        if (usuario.getTipoDocumento()!=null) {
            usuarioDTO.setTipoDocumento(usuario.getTipoDocumento().getNombre());
        }else{
            usuarioDTO.setTipoDocumento(null);
        }
        if (usuario.getEstados()!=null){
           usuarioDTO.setEstados(usuario.getEstados().getNombre());
        }else{
           usuarioDTO.setEstados(null);
        }
        if (usuario.getPaises()!=null){
            usuarioDTO.setPaises(usuario.getPaises().getNombre());
        }else{
            usuarioDTO.setPaises(null);
        }
        if (usuario.getRoles()!=null){
            usuarioDTO.setRoles(usuario.getRoles().getNombre());
        }else{
            usuarioDTO.setRoles(null);
        }
        return usuarioDTO;
    }

    public List<UsuarioDTO> visualizarUsuarios(){
        List<UsuarioDTO> usuarioDTOS = iU.findAll();
        return tipoDocumentos.stream().map(this::trasnforDTO).collect(Collectors.toList());
    }

}
