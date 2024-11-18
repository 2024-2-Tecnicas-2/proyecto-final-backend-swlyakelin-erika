package com.proyecto.SWL.DTO;

import lombok.Data;

import java.util.Date;



@Data
public class UsuarioDTO {
    private Long idUsuario;
    private String nombre;
    private String email;
    private String contrasena;
    private Date fechaNacimiento;
    private String numeroDocumento;
    private String estados;
    private String roles;
    private String tipoDocumento;
    private String paises;
}
