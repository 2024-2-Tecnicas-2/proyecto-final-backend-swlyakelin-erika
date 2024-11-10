package com.proyecto.SWL.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoDocumentosDTO {
    private Long idDocumento;
    private String nombre;
    private Long idestados;
    private String nombreEstado;

}
