package com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest;

import com.example.hoteleria.Habitaciones.Aplicacion.Service.CrearHabitacion.CrearHabitacionDTO;
import com.example.hoteleria.Habitaciones.Aplicacion.Service.ListarHabitaciones.ListarHabitacionesPorHotelDTO;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.BuscarHabitacionInputPort;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.CreacionHabitacionInputPort;
import com.example.hoteleria.Habitaciones.Aplicacion.ports.input.ListarHabitacionesInputPort;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Mapper.CreacionHabitacionRestMapper;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Response.BuscarHabitacionResponseDTO;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Response.CrearHabitacionResponseDTO;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Response.ListarHabitacionesResponseDTO;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Input.Rest.Model.Response.HotelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/habitaciones")
public class HabitacionesRestAdapter {
    private final CreacionHabitacionInputPort creacionHabitacionInputPort;
    private final ListarHabitacionesInputPort listarHabitacionesInputPort;
    private final BuscarHabitacionInputPort buscarHabitacionInputPort;
    private final CreacionHabitacionRestMapper creacionHabitacionRestMapper;

    @GetMapping("{hotel_id}")
    public List<ListarHabitacionesResponseDTO> allHabitacionesPorHotel(@Valid @PathVariable Long hotel_id) {
        ListarHabitacionesPorHotelDTO listarHabitacionesPorHotelDTO = new ListarHabitacionesPorHotelDTO(hotel_id);
        return  this.creacionHabitacionRestMapper.toHabitacionesListaResponse(this.listarHabitacionesInputPort.listarHabitaciones(listarHabitacionesPorHotelDTO));
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CrearHabitacionResponseDTO> crearHabitacion(@Valid @RequestBody CrearHabitacionDTO crearHabitacionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.creacionHabitacionRestMapper.toHabitacionResponse(
                        creacionHabitacionInputPort.crearHabitacion((crearHabitacionDTO))
                ));
    }


    @GetMapping("/habitacion/{habitacion_id}")
    public BuscarHabitacionResponseDTO obtenerHabitacion(@Valid @PathVariable UUID habitacion_id) {
        return  this.creacionHabitacionRestMapper.toBuscarHabitacionResponse(this.buscarHabitacionInputPort.buscarHabitacion(habitacion_id));
    }
}
