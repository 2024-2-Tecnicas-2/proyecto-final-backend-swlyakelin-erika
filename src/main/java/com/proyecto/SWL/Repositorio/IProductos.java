package com.proyecto.SWL.Repositorio;

import com.proyecto.SWL.Modelo.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductos extends JpaRepository<Productos,Long> {
    Optional<Productos> findBynombre(String nombre);
}
