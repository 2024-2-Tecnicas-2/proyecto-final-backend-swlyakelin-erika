package com.proyecto.SWL.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "Administrador")
public class Administador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para que se cree solo el id y se genere automaticamente
    private Long idAdministrador;
}
