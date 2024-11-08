package com.proyecto.SWL.Repositorio;
import com.proyecto.SWL.Modelo.Estados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstados extends JpaRepository<Estados,Long> {

}
