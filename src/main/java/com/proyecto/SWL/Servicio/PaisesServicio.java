package com.proyecto.SWL.Servicio;

import com.proyecto.SWL.DTO.PaisesDTO;
import com.proyecto.SWL.Modelo.Paises;
import com.proyecto.SWL.Repositorio.IPaises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisesServicio {


    @Autowired
    private IPaises ipaises;

    private PaisesDTO transforDTO(Paises paises){
        PaisesDTO paisesDTO = new PaisesDTO();
        paisesDTO.setIdPais(paises.getIdPais());
        paisesDTO.setNombre(paises.getNombre());
        paisesDTO.setMonedaPais(paises.getMonedaPais());
        return paisesDTO;
    }

    public List<PaisesDTO> visualizar(){
    List<Paises> paises = ipaises.findAll();
    return paises.stream().map(this::transforDTO).collect(Collectors.toList());
    }

    public void GuardarNuevoPais(PaisesDTO paisesDTO){
        Paises p = new Paises();
        p.setNombre(paisesDTO.getNombre());
        p.setMonedaPais(paisesDTO.getMonedaPais());
        ipaises.save(p);
    }

    public PaisesDTO ObtenerPaisId(Long id){
        Paises p = ipaises.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro el pais"));
        PaisesDTO paisesDTO = transforDTO(p);
        return paisesDTO;
    }


    public void EditarPaises(PaisesDTO paisesDTO){
        Paises p = ipaises.findById(paisesDTO.getIdPais())
                .orElseThrow(()->new RuntimeException("No se encontro el pais"));
        p.setNombre(paisesDTO.getNombre());
        p.setMonedaPais(paisesDTO.getMonedaPais());
        ipaises.save(p);
    }







}
