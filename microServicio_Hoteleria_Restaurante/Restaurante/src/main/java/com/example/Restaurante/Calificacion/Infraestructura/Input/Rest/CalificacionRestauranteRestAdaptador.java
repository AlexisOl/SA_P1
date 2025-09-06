package com.example.Restaurante.Calificacion.Infraestructura.Input.Rest;

import com.example.Restaurante.Calificacion.Aplicacion.Ports.Input.CrearCalificacionRestauranteInputPort;
import com.example.Restaurante.Calificacion.Aplicacion.Service.CrearCalificacion.CrearCalificacionRestauranteDTO;
import com.example.Restaurante.Calificacion.Infraestructura.Input.Rest.Mapper.CalificacionRestauranteRestMapper;
import com.example.Restaurante.Calificacion.Infraestructura.Input.Rest.Model.Output.ResponseCalificacionPlatilloDTO;
import com.example.Restaurante.Platillos.Aplicacion.Service.CasoUsoCrearPlatillo.CrearPlatilloDTO;
import com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Model.Output.ResponsePlatillosDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/calificacionRestaurante")
public class CalificacionRestauranteRestAdaptador {


    private final CrearCalificacionRestauranteInputPort  crearCalificacionRestauranteInputPort;
    private final CalificacionRestauranteRestMapper  calificacionRestauranteRestMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseCalificacionPlatilloDTO> crearCalificacionPlatillo(@RequestBody List<CrearCalificacionRestauranteDTO> crearCalificacionRestauranteDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        this.calificacionRestauranteRestMapper.toResponseCalificacionPlatilloDto(
                                this.crearCalificacionRestauranteInputPort.createCalificacionRestaurante(
                                        crearCalificacionRestauranteDTO
                                )
                        )
                );

    }

}
