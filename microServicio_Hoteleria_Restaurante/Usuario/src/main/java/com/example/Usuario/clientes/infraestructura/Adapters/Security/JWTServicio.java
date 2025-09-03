package com.example.Usuario.clientes.infraestructura.Adapters.Security;

import com.example.Usuario.clientes.Dominio.Model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTServicio {
    @Value("${spring.security.jwt.secret-key}")
    private String llave;
    @Value("${spring.security.jwt.secret-expiration-time}")
    private long jwtExpiracion;


    public String extraerUsername(String token){
        return  extraerElementos(token, claims -> claims.get("username", String.class));
    }

    public <T> T extraerElementos(String token, Function<Claims, T> resolucionClaims){
        final Claims claims = extraerTodasLasClaims(token);
        return  resolucionClaims.apply(claims);

    }

    //para generar
    public String obtenerToken(Usuario userDetails){
        return  obtenerToken(new HashMap<>(), userDetails);
    }

    public String obtenerToken(Map<String, Object> extraClaims, Usuario userDetails) {

        return construirToken(extraClaims, userDetails, jwtExpiracion);
    }

    private String construirToken(Map<String, Object> extraClaims, Usuario userDetails, Long tiempoExpiracion) {

        System.out.println(userDetails);
        Claims claims = Jwts.claims().setSubject(String.valueOf(userDetails.getId()));
        claims.put("id",userDetails.getId());
        claims.put("email",userDetails.getUsername());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+tiempoExpiracion*10))
                .signWith(getLlaveIngreso(), SignatureAlgorithm.HS256)
                .compact();
    }


    //fucnion para obtener el tiempo de expiracion

    public Long ObtenerTiempoExpiracion(){
        return  jwtExpiracion;
    }


    // para verificar que si sea valido

    public boolean esValido(String token, UserDetails userDetails){
        final String cadena = extraerUsername(token);
        return (cadena.equals(userDetails.getUsername()) && !isTokenExpired(token));

    }


    private Date getExpiration(String token)
    {
        return extraerElementos(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token)
    {
        return getExpiration(token).before(new Date());
    }

    private Claims extraerTodasLasClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getLlaveIngreso())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //decodifica y me lo da
    private Key getLlaveIngreso() {
        byte[] keyBytes = Decoders.BASE64.decode(llave);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
