package com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest;

import com.example.hoteleria.Habitaciones.Aplicacion.Service.CrearHabitacion.CrearHabitacionDTO;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.CreacionHabitacionInputPort;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Mapper.CreacionHabitacionRestMapper;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Response.CrearHabitacionResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/habitaciones")
public class HabitacionesRestAdapter {
    private final CreacionHabitacionInputPort creacionHabitacionInputPort;
    private final CreacionHabitacionRestMapper creacionHabitacionRestMapper;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CrearHabitacionResponseDTO> crearHabitacion(@Valid @RequestBody CrearHabitacionDTO crearHabitacionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.creacionHabitacionRestMapper.toHabitacionResponse(
                        creacionHabitacionInputPort.crearHabitacion((crearHabitacionDTO))
                ));
    }
}
