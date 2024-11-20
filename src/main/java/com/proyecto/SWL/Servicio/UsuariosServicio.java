<<<<<<< HEAD
=======
package com.proyecto.SWL.Servicio;

import com.proyecto.SWL.DTO.TipoDocumentosDTO;
import com.proyecto.SWL.DTO.UsuarioDTO;
import com.proyecto.SWL.Modelo.*;

import com.proyecto.SWL.Repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuariosServicio {

    @Autowired
    private ITipoDocumentos iTipoDocumentos;
    @Autowired
    private IEstados iEstados;
    @Autowired
    private IUsuarios iUsuarios ;
    @Autowired
    private IRoles iRoles ;
    @Autowired
    private IPaises iPaises ;

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
        List<Usuario> usuarios = iUsuarios.findAll();
        return usuarios.stream().map(this::trasnforDTO).collect(Collectors.toList());
    }

    public void GuardarNuevoUsuario(UsuarioDTO usuarioDTO){
       Usuario u = new Usuario();
        u.setNombre(usuarioDTO.getNombre());
        u.setEmail(usuarioDTO.getEmail());
        u.setContrasena(usuarioDTO.getContrasena());
        u.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
        u.setNumeroDocumento(usuarioDTO.getNumeroDocumento());
        Roles roles = iRoles.findById(usuarioDTO.getIdRoles())
                .orElseThrow(() -> new RuntimeException("No se encontró el rol con el ID proporcionado"));
        u.setRoles(roles);
        Estados estados = iEstados.findBynombre("Activo")
                .orElseThrow(()->new RuntimeException("No se encontro el estado"));
        u.setEstados(estados);
        TipoDocumentos tipoDocumentos = iTipoDocumentos.findById(usuarioDTO.getIdTipoD())
                .orElseThrow(() -> new RuntimeException("No se encontró el id de documento"));
        u.setTipoDocumento(tipoDocumentos);
        Paises paises= iPaises.findById(usuarioDTO.getIdPaises())
                .orElseThrow(() -> new RuntimeException("No se encontró el id de paises"));
        u.setPaises(paises);

        iUsuarios.save(u);
    }

    public UsuarioDTO ObtenerUsuarioId(Long id){
        Usuario u = iUsuarios.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro el Usuario"));
       UsuarioDTO usuarioDTO = trasnforDTO(u);
        return usuarioDTO;
    }

    public void EditarUsuario(UsuarioDTO usuarioDTO){
        Usuario u = iUsuarios.findById(usuarioDTO.getIdUsuario())
                .orElseThrow(()->new RuntimeException("No se encontro el documento"));
        u.setNombre(usuarioDTO.getNombre());
        u.setNombre(usuarioDTO.getNombre());
        u.setEmail(usuarioDTO.getEmail());
        u.setContrasena(usuarioDTO.getContrasena());
        u.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
        u.setNumeroDocumento(usuarioDTO.getNumeroDocumento());
        Estados estados = iEstados.findBynombre("Activo")
                .orElseThrow(()->new RuntimeException("No se encontro el estado"));
        u.setEstados(estados);
        Roles roles = iRoles.findById(usuarioDTO.getIdRoles())
                .orElseThrow(() -> new RuntimeException("No se encontró el rol con el ID proporcionado"));
        u.setRoles(roles);
        TipoDocumentos tipoDocumentos = iTipoDocumentos.findById(usuarioDTO.getIdTipoD())
                .orElseThrow(() -> new RuntimeException("No se encontró el id de documento"));
        u.setTipoDocumento(tipoDocumentos);
        Paises paises= iPaises.findById(usuarioDTO.getIdPaises())
                .orElseThrow(() -> new RuntimeException("No se encontró el id de paises"));
        u.setPaises(paises);
        iUsuarios.save(u);
    }


}
>>>>>>> 5105c0fd08bcff02dbc07f2716527e838a945686
