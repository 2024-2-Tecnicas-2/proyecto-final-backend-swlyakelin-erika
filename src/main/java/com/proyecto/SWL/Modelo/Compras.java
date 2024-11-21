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
    private String fechaVenta;
    private Double monto;

    @ManyToOne(fetch = FetchType.LAZY) //Lazy es como una busqueda perezosa te trae la lista que tienen esa relacion, fecht = busqueda
    @JoinColumn(name = "idEstado") // JoinColumn sirve para nombrar la columna de la relacion
    private Estados estados; // llamando el objecto

    @ManyToOne(fetch = FetchType.LAZY) //Lazy es como una busqueda perezosa te trae la lista que tienen esa relacion, fecht = busqueda
    @JoinColumn(name = "producto") // JoinColumn sirve para nombrar la columna de la relacion
    private Productos productos; // llamando el objecto

    @ManyToOne(fetch = FetchType.LAZY) //Lazy es como una busqueda perezosa te trae la lista que tienen esa relacion, fecht = busqueda
    @JoinColumn(name = "usuario") // JoinColumn sirve para nombrar la columna de la relacion
    private Usuario usuario; // llamando el objecto

    @ManyToOne(fetch = FetchType.LAZY) //Lazy es como una busqueda perezosa te trae la lista que tienen esa relacion, fecht = busqueda
    @JoinColumn(name = "metodoPago") // JoinColumn sirve para nombrar la columna de la relacion
    private Pagos pagos; // llamando el objecto

    @ManyToOne(fetch = FetchType.LAZY) //Lazy es como una busqueda perezosa te trae la lista que tienen esa relacion, fecht = busqueda
    @JoinColumn(name = "moneda") // JoinColumn sirve para nombrar la columna de la relacion
    private Paises paises; // llamando el objecto

}
