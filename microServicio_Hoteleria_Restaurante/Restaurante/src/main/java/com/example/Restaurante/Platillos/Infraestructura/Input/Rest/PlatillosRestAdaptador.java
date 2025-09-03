package com.example.Restaurante.Platillos.Infraestructura.Input.Rest;

import com.example.Restaurante.Platillos.Aplicacion.Ports.Input.CrearPlatilloInputPort;
import com.example.Restaurante.Platillos.Aplicacion.Service.CasoUsoCrearPlatillo.CrearPlatilloDTO;
import com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Mapper.PlatillosRestMapper;
import com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Model.Output.ResponsePlatillosDTO;
import com.example.Restaurante.Restaurante.Aplicacion.Service.CasoUsoCreacionRestaurante.CreacionRestauranteDTO;
import com.example.Restaurante.Restaurante.Infraestructura.Input.Rest.Model.Output.ResponseRestauranteDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/platillos")
public class PlatillosRestAdaptador {


    private final PlatillosRestMapper platillosRestMapper;
    private final CrearPlatilloInputPort crearPlatilloInputPort;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponsePlatillosDTO> crearPlatillo(@RequestBody CrearPlatilloDTO crearPlatilloDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        this.platillosRestMapper.toResponsePlatillosDTO(
                                this.crearPlatilloInputPort.crearPlatillos(
                                        crearPlatilloDTO
                                )
                        )
                );

    }
}
