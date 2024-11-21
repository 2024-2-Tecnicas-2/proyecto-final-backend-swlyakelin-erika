package com.proyecto.SWL.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "productos" , cascade = {CascadeType.MERGE,CascadeType.PERSIST}) // mappeBy es para busca el objecto , cascade = sirve para la crud esta relacion de merge y persist es para controlar las relaciones
    private Set<Compras> compras = new HashSet<>(); // Set =  Los elementos que almacenes en un Set no pueden ser duplicados HashSet = HashSet es una implementación de la interfaz Set que no garantiza el orden de los elementos, pero asegura que cada objeto sea único.


}
