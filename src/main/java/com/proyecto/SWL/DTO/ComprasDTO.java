package com.proyecto.SWL.DTO;

import com.proyecto.SWL.Modelo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComprasDTO {

    private Long idVenta;
    private Date fechaVenta;
    private Double monto;
    private Double trmAplicada;
}

