package com.proyecto.SWL.Repositorio;


import com.proyecto.SWL.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarios extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findBynumeroDocumento (Integer numeroDocumento);
}
