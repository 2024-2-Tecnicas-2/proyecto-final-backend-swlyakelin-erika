package com.proyecto.SWL.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    private String nombre;
    private Double precio;
    private String categoria;
    private ArrayList<Estados> estados = new ArrayList<Estados>();

    public void crearProductos(){}
    public void editarProductos(){}

}
