package com.proyecto.SWL.Repositorio;

import com.proyecto.SWL.Modelo.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoles extends JpaRepository<Roles,Long> {
    Optional<Roles> findBynombre (String nombre);
}
