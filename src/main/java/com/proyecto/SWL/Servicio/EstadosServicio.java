package com.proyecto.SWL.Servicio;


import com.proyecto.SWL.DTO.EstadosDTO;
import com.proyecto.SWL.Modelo.Estados;
import com.proyecto.SWL.Repositorio.IEstados;
import com.proyecto.SWL.Repositorio.IRoles;
import com.proyecto.SWL.Repositorio.ITipoDocumentos;
import com.proyecto.SWL.Repositorio.IUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadosServicio {

    @Autowired
    private IEstados iEstados;
    @Autowired
    private ITipoDocumentos iTipoDocumentos;
    @Autowired
    private IRoles iRoles;
    @Autowired
    private IUsuarios iUsuarios;

    private EstadosDTO estadosDTO(Estados estados){
        EstadosDTO estadosDTO = new EstadosDTO();
        estadosDTO.setIdEstado(estados.getIdEstado());
        estadosDTO.setNombre(estados.getNombre());
        estadosDTO.setTipoEstado(estados.getTipoEstado());
        return estadosDTO;
    }

    public List<EstadosDTO> visualizarEstados(){
        List<Estados> estados = iEstados.findAll();
        return estados.stream().map(this::estadosDTO).collect(Collectors.toList());
    }

    public void GuardarNuevoEstado(EstadosDTO estadosDTO){
        Estados e = new Estados();
        e.setNombre(estadosDTO.getNombre());
        e.setTipoEstado(estadosDTO.getTipoEstado());

        iEstados.save(e);
    }

    public EstadosDTO ObtenerEstadosId(Long id){
        Estados e = iEstados.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro el estado"));
        EstadosDTO estadosDTO = estadosDTO(e);
        return estadosDTO;
    }


    public void EditarEstados(EstadosDTO estadosDTO){
        Estados e = iEstados.findById(estadosDTO.getIdEstado())
                .orElseThrow(()->new RuntimeException("No se encontro el estado"));
        e.setNombre(estadosDTO.getNombre());
        e.setTipoEstado(estadosDTO.getTipoEstado());

        iEstados.save(e);
    }
}
