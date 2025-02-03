package com.andres.curso.java.springboot.backend.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Para este ejemplo, vamos a devolver un usuario estático
        if ("user".equals(username)) {
            String encodedPassword = new BCryptPasswordEncoder().encode("password");
            return User.withUsername("user")
                    .password(encodedPassword)
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }

        /*return User.withUsername("user")
                .password("{noop}password") // {noop} indica que no se debe aplicar ningún codificador de contraseñas
                .roles("USER")
                .build();*/

        // Aquí debes cargar el usuario desde tu base de datos o cualquier otra fuente
        // Por ejemplo:
        // User user = userRepository.findByUsername(username);
        // if (user == null) {
        //     throw new UsernameNotFoundException("User not found");
        // }
        // return new MyUserDetails(user);
    }
}