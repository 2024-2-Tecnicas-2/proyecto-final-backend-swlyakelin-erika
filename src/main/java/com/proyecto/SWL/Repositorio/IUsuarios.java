package com.proyecto.SWL.Repositorio;


import com.proyecto.SWL.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarios extends JpaRepository<Usuario, Long> {
}
