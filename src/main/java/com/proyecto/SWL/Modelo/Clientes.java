package com.proyecto.SWL.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para que se cree solo el id y se genere automaticamente
    private Long idCliente;
    private Long numeroCuenta;
    private Double saldoCuenta;


    public void realizarCompra(){}
}
