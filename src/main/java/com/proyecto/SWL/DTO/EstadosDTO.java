package com.proyecto.SWL.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadosDTO {

    private Long idEstado;
    private String nombre;
    private String tipoEstado;

}

