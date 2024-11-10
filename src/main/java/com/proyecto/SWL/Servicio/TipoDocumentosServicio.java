package com.proyecto.SWL.Servicio;


import com.proyecto.SWL.DTO.PaisesDTO;
import com.proyecto.SWL.DTO.TipoDocumentosDTO;
import com.proyecto.SWL.Modelo.Estados;
import com.proyecto.SWL.Modelo.Paises;
import com.proyecto.SWL.Modelo.TipoDocumentos;
import com.proyecto.SWL.Repositorio.IEstados;
import com.proyecto.SWL.Repositorio.ITipoDocumentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoDocumentosServicio {

    @Autowired
    private ITipoDocumentos iTipoDocumentos;
    @Autowired
    private IEstados iEstados;

    private TipoDocumentosDTO trasnforDTO(TipoDocumentos tipoDocumentos){
        TipoDocumentosDTO tipoDocumentosDTO = new TipoDocumentosDTO();
        tipoDocumentosDTO.setIdDocumento(tipoDocumentos.getIdDocumento());
        tipoDocumentosDTO.setNombre(tipoDocumentos.getNombre());
        if (tipoDocumentos.getEstados()!=null){
            tipoDocumentosDTO.setNombreEstado(tipoDocumentos.getEstados().getNombre());
        }else{
            tipoDocumentosDTO.setNombreEstado(null);
        }
        return tipoDocumentosDTO;
    }

    public List<TipoDocumentosDTO> visualizarDocumentos(){
        List<TipoDocumentos> tipoDocumentos = iTipoDocumentos.findAll();
        return tipoDocumentos.stream().map(this::trasnforDTO).collect(Collectors.toList());
    }

    public void GuardarNuevoDocumento(TipoDocumentosDTO tipoDocumentosDTO){
        TipoDocumentos d = new TipoDocumentos();
        d.setNombre(tipoDocumentosDTO.getNombre());
        Estados estados = iEstados.findBynombre("Activo")
                .orElseThrow(()->new RuntimeException("No se encontro el estado"));
        d.setEstados(estados);
        iTipoDocumentos.save(d);
    }

    public TipoDocumentosDTO ObtenerDocumentoId(Long id){
        TipoDocumentos d = iTipoDocumentos.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro el documento"));
        TipoDocumentosDTO tipoDocumentosDTO = trasnforDTO(d);
        return tipoDocumentosDTO;
    }


    public void EditarDDocumento(TipoDocumentosDTO tipoDocumentosDTO){
        TipoDocumentos d = iTipoDocumentos.findById(tipoDocumentosDTO.getIdDocumento())
                .orElseThrow(()->new RuntimeException("No se encontro el documento"));
        d.setNombre(tipoDocumentosDTO.getNombre());
        Estados estados = iEstados.findById(tipoDocumentosDTO.getIdestados())
                        .orElseThrow(()->new RuntimeException("No se encontro el id estado"));
        d.setEstados(estados);
        iTipoDocumentos.save(d);
    }



}

