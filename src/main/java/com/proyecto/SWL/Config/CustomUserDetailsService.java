package com.proyecto.SWL.Config;

import com.proyecto.SWL.Modelo.Roles;
import com.proyecto.SWL.Modelo.Usuario;
import com.proyecto.SWL.Repositorio.IUsuarios;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarios iUsuarios;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        int numeroDocumento = Integer.parseInt(username);
        Optional<Usuario> optionalUsuario = iUsuarios.findBynumeroDocumento(numeroDocumento);
        Usuario usuario = optionalUsuario.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con número de documento: " + username));

        Roles rol = usuario.getRoles();

        if (rol == null) {
            throw new UsernameNotFoundException("El usuario no tiene un rol asignado.");
        }

        System.out.println("Rol cargado: " + rol.getNombre());

        Collection<? extends GrantedAuthority> authorities = getAuthorities(rol);
        return new org.springframework.security.core.userdetails.User(
                String.valueOf(usuario.getNumeroDocumento()),
                usuario.getContrasena(),
                authorities
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Roles rol) {
        return Collections.singletonList(new SimpleGrantedAuthority(rol.getNombre()));
    }
}
