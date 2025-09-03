package com.example.Restaurante.Restaurante.Infraestructura.Input.Rest;


import com.example.Restaurante.Restaurante.Aplicacion.Ports.Input.CreacionRestauranteInputPort;
import com.example.Restaurante.Restaurante.Aplicacion.Ports.Input.ListarRestaturantesInputPort;
import com.example.Restaurante.Restaurante.Aplicacion.Ports.Input.ListarRestaurantesEspecificosInputPort;
import com.example.Restaurante.Restaurante.Aplicacion.Ports.Output.ListarRestaurantesOutputPort;
import com.example.Restaurante.Restaurante.Aplicacion.Service.CasoUsoCreacionRestaurante.CreacionRestauranteDTO;
import com.example.Restaurante.Restaurante.Dominio.Restaurante;
import com.example.Restaurante.Restaurante.Infraestructura.Input.Rest.Mapper.RestauranteRestMappper;
import com.example.Restaurante.Restaurante.Infraestructura.Input.Rest.Model.Input.RequestRestauranteDTO;
import com.example.Restaurante.Restaurante.Infraestructura.Input.Rest.Model.Output.ResponseRestauranteDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurante")
public class RestauranteRestAdapter {


    private final CreacionRestauranteInputPort creacionRestauranteInputPort;
    private final ListarRestaturantesInputPort listarRestaturantesInputPort;
    private final ListarRestaurantesEspecificosInputPort ListarReservacionEspecifica;
    private final RestauranteRestMappper restauranteRestMappper;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseRestauranteDTO> crearRestaurante(@RequestBody CreacionRestauranteDTO creacionRestauranteDTO) {

    return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        this.restauranteRestMappper.toRestauranteResponse(
                                this.creacionRestauranteInputPort.crearRestaurante(
                                        creacionRestauranteDTO
                                        )
                        )
                );

    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseRestauranteDTO> listarRestaurantes() {
        return this.restauranteRestMappper.toListRestauranteResponse(this.listarRestaturantesInputPort.listarRestaurantes());
    }


    @GetMapping("/{id}")
    public ResponseRestauranteDTO listarRestauranteEspecifico(@PathVariable UUID id) {
        Restaurante restaurante = this.ListarReservacionEspecifica
                .listarRestauranteEspecifico(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Restaurante no encontrado con id: " + id
                ));


        return this.restauranteRestMappper.toRestauranteResponse(restaurante);

    }

}
