package com.proyecto.SWL.Repositorio;
import com.proyecto.SWL.Modelo.Estados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IEstados extends JpaRepository<Estados,Long> {
    Optional<Estados> findBynombre(String nombre);
}
