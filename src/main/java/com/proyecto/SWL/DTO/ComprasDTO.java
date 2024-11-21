package com.proyecto.SWL.DTO;

import com.proyecto.SWL.Modelo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data

public class ComprasDTO {

    private Long idVenta;
    private String fechaVenta;
    private Double monto;
    private Long idEstados;
    private String estados;
    private Long idPaises;
    private String paises;
    private Long idProductos;
    private String productos;
    private Long idpago;
    private String pagos;
}

