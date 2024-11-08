package com.proyecto.SWL.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Trm")
public class Trm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para que se cree solo el id y se genere automaticamente
    private Long idTrm;
    private double valorActual;
    private Date fecha;

    public void consultarTRM(){}
    public void visualizarTRM(){}


}
