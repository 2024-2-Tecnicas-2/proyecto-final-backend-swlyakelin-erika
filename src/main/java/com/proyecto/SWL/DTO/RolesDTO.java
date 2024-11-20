package com.proyecto.SWL.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolesDTO {

    private Long idRol;
    private String nombre;
    private Long idestados;
    private String estados;
}

