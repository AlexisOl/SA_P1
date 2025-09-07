package com.example.hoteleria.Calificacion.Infraestructura.Input.Rest;

import com.example.hoteleria.Calificacion.Aplicacion.Ports.Input.CrearCalificacionInputPort;
import com.example.hoteleria.Calificacion.Aplicacion.Ports.Input.ListarCalificacionesInputPort;
import com.example.hoteleria.Calificacion.Aplicacion.Service.CasosUso.CrearCalificacionCasoUso.CrearCalificacionDTO;
import com.example.hoteleria.Calificacion.Infraestructura.Input.Rest.Mapper.CalificacionRestMapper;
import com.example.hoteleria.Calificacion.Infraestructura.Input.Rest.Model.Output.ResponseCalificacionDTO;
import com.example.hoteleria.Rerservacion.Infraestructura.Input.Rest.Model.Response.ReservacionResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/calificacion")
public class CalificacionRestAdaptador {

    private final CalificacionRestMapper calificacionRestMapper;
    private final ListarCalificacionesInputPort listarCalificacionesInputPort;
    private final CrearCalificacionInputPort crearCalificacionInputPort;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseCalificacionDTO> crearCalificacion(@Valid @RequestBody CrearCalificacionDTO crearCalificacionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.calificacionRestMapper.toResponseCalificacion(
                        crearCalificacionInputPort.crearCalificacion((crearCalificacionDTO))
                ));
    }

    @GetMapping("/habitacion/{id}")
    public List<ResponseCalificacionDTO> listadoCalificacionesPorHabitacion(@PathVariable UUID id) {
        return this.calificacionRestMapper.toListResponseCalificacionDtoList(this.listarCalificacionesInputPort.listarCalificacionesPorHabitacion(id)) ;
    }

}
