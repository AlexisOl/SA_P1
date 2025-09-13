package com.example.Usuario.clientes.infraestructura.Adapters.Security;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output.EmpleadoHotelPorCuiOutputport;
import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Output.EmpleadoRestaurantePorCuiOutputPort;
import com.example.Usuario.EmpleadoRestaurante.Dominio.EmpleadoRestaurante;
import com.example.Usuario.clientes.Dominio.Model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private final EmpleadoHotelPorCuiOutputport empleadoHotelPorCuiOutputport;

    @Autowired
    private final EmpleadoRestaurantePorCuiOutputPort empleadoRestaurantePorCuiOutputPort;

    public JWTServicio(EmpleadoHotelPorCuiOutputport empleadoHotelPorCuiOutputport, EmpleadoRestaurantePorCuiOutputPort empleadoRestaurantePorCuiOutputPort) {
        this.empleadoHotelPorCuiOutputport = empleadoHotelPorCuiOutputport;
        this.empleadoRestaurantePorCuiOutputPort = empleadoRestaurantePorCuiOutputPort;
    }

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

        System.out.println(userDetails.getTipoEmpleado()+ "--"+ userDetails.getPersona().getCui());



            // en caso de ser empleado buscar
            EmpleadoHotel obtieneEmpleadoHotel = this.empleadoHotelPorCuiOutputport.obtenerEmpleaado(userDetails.getPersona());
            EmpleadoRestaurante obtieneEmpleadoRestaurante = this.empleadoRestaurantePorCuiOutputPort.obtenerEmpleaado(userDetails.getPersona());

        Claims claims = Jwts.claims().setSubject(String.valueOf(userDetails.getId()));
        claims.put("id",userDetails.getId());
        claims.put("username",userDetails.getUsername());
        claims.put("password",userDetails.getPassword());
        claims.put("tipo",userDetails.getTipoEmpleado());
        claims.put("id_HOTEL",  obtieneEmpleadoHotel!=null ?  obtieneEmpleadoHotel.getIdhotel(): "No tiene");
        claims.put("id_RESTAURANTE",obtieneEmpleadoRestaurante!=null ?  obtieneEmpleadoRestaurante.getRestauranteId(): "No tiene");

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
