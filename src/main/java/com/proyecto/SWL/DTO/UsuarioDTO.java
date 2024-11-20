package com.proyecto.SWL.DTO;

import lombok.Data;

import java.util.Date;



@Data
public class UsuarioDTO {
    private Long idUsuario;
    private String nombre;
    private String email;
    private String contrasena;
    private String fechaNacimiento;
    private Integer numeroDocumento;
    private Long idEstados;
    private String estados;
    private Long idRoles;
    private String roles;
    private Long idTipoD;
    private String tipoDocumento;
    private Long idPaises;
    private String paises;
}
