package com.proyecto.SWL.Repositorio;


import com.proyecto.SWL.Modelo.Paises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPaises  extends JpaRepository<Paises, Long> {

}
