package com.example.Restaurante.Calificacion.Infraestructura.Input.Rest;

import com.example.Restaurante.Calificacion.Aplicacion.Ports.Input.CrearCalificacionRestauranteInputPort;
import com.example.Restaurante.Calificacion.Aplicacion.Ports.Output.ListarComentarioPlatilloOutputPort;
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
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/calificacionRestaurante")
public class CalificacionRestauranteRestAdaptador {


    private final CrearCalificacionRestauranteInputPort  crearCalificacionRestauranteInputPort;
    private final CalificacionRestauranteRestMapper  calificacionRestauranteRestMapper;
    private final ListarComentarioPlatilloOutputPort listarComentarioPlatilloOutputPort;

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

    @GetMapping("/restaurante/{id}")
    public List<ResponseCalificacionPlatilloDTO> listadoCalificacionesPorPlatillo(@PathVariable UUID id) {
        return this.calificacionRestauranteRestMapper.toListResponseCalificacionPlatilloDto(this.listarComentarioPlatilloOutputPort.listarComentarioPlatillo(id)) ;
    }

}
