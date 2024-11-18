package com.proyecto.SWL.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductosDTO {

    private Long idProductos;
    private String nombre;
    private Double precio;
    private String categoria;

}

