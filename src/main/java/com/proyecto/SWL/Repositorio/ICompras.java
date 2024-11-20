package com.proyecto.SWL.Repositorio;

import com.proyecto.SWL.Modelo.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICompras extends JpaRepository<Compras,Long> {

}
