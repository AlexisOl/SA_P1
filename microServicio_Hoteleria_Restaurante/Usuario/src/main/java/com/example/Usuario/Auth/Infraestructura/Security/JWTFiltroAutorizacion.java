package com.example.Usuario.Auth.Infraestructura.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
public class JWTFiltroAutorizacion extends OncePerRequestFilter {

    @Autowired
    private JWTServicio jwtServicio;
    private HandlerExceptionResolver handlerExceptionResolver;
    private UserDetailsService userDetailsService;


    //constructor

    public JWTFiltroAutorizacion(
            JWTServicio jwtServicio,
            UserDetailsService userDetailsService,
            HandlerExceptionResolver handlerExceptionResolver
    ) {
        this.jwtServicio = jwtServicio;
        this.userDetailsService = userDetailsService;
        this.handlerExceptionResolver = handlerExceptionResolver;
    }


    public String getTokenRequest(HttpServletRequest valor){
        final String authHeader=valor.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")){
            System.out.println(authHeader.substring(7)+"--------------");
            System.out.println(authHeader+"////////////////////////////////////");

            return authHeader.substring(7);

        }
        return null;
    }


    //metodo general
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // token
        final String token = getTokenRequest(request);
        final String email;

        //si no hay token, continúa con la cadena de filtros sin hacer nada
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }

        //si hay un token, obtiene el nombre de usuario desde el JWT
        email = jwtServicio.extraerUsername(token);

        //si hay un nombre de usuario y no hay autenticación previa en el contexto de seguridad
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            //busca el usuario en la base de datos
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            System.out.println(userDetails.getAuthorities());
            System.out.println(userDetails.getUsername());

            //si el token es válido, crea la autenticación
            if (jwtServicio.esValido(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());

                //añade los detalles de la solicitud al token de autenticación
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //establece la autenticación en el contexto de seguridad
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        //continúa con el siguiente filtro en la cadena
        filterChain.doFilter(request, response);
    }
}