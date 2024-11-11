package com.proyecto.SWL.Servicio;

import com.proyecto.SWL.DTO.RolesDTO;
import com.proyecto.SWL.Modelo.Roles;
import com.proyecto.SWL.Repositorio.IRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolesServicio {


    @Autowired
    private IRoles iroles;

    private RolesDTO transforDTO(Roles roles){
        RolesDTO rolesDTO = new RolesDTO();
        rolesDTO.setIdRol(roles.getIdRol());
        rolesDTO.setNombre(roles.getNombre());
        return rolesDTO;
    }

    public List<RolesDTO> visualizar(){
    List<Roles> roles = iroles.findAll();
    return roles.stream().map(this::transforDTO).collect(Collectors.toList());
    }

    public void GuardarNuevoRol(RolesDTO rolesDTO){
        Roles r = new Roles();
        r.setNombre(rolesDTO.getNombre());
        iroles.save(r);
    }

    public RolesDTO ObtenerRolId(Long id){
        Roles r = iroles.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro el rol"));
        RolesDTO rolesDTO = transforDTO(r);
        return rolesDTO;
    }

    public void EditarRoles(RolesDTO rolesDTO){
        Roles r = iroles.findById(rolesDTO.getIdRol())
                .orElseThrow(()->new RuntimeException("No se encontro el rol"));
        r.setNombre(rolesDTO.getNombre());
        iroles.save(r);
    }
}