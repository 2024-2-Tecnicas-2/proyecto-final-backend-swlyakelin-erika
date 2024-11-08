package com.proyecto.SWL.Modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Compras")
public class Compras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenta;
    private Date fechaVenta;
    private Double monto;
    private Double trmAplicada;
    private ArrayList<Estados> estados = new ArrayList<Estados>();
    private ArrayList<Productos> producto = new ArrayList<Productos>();
    private ArrayList<Usuario> usuario = new ArrayList<Usuario>();
    private ArrayList<Pagos>  metodoPago = new ArrayList<Pagos>();
    private ArrayList<Paises>  moneda = new ArrayList<Paises>();


    public void generarVenta(){}
    public void actualizarVenta(){}
    public void anularVenta(){}
    public void visualizarVenta(){}
}
