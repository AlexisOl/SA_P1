package com.example.hoteleria.Rerservacion.Infraestructura.Input.Rest;


import com.example.hoteleria.Habitaciones.Aplicacion.Service.CrearHabitacion.CrearHabitacionDTO;
import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Response.CrearHabitacionResponseDTO;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Input.CrearReservacionInputPort;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.CrearReservacionOutputPort;
import com.example.hoteleria.Rerservacion.Aplicacion.Service.CasosUso.CrearReservacion.CrearReservacionDTO;
import com.example.hoteleria.Rerservacion.Infraestructura.Input.Rest.Mapper.CreacionReservacionMapperRest;
import com.example.hoteleria.Rerservacion.Infraestructura.Input.Rest.Model.Response.ReservacionResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/reservacion")
public class ReservacionRestAdapter {

    private final CrearReservacionInputPort crearReservacionInputPort;
    private final CreacionReservacionMapperRest   creacionReservacionMapperRest;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ReservacionResponseDTO> crearReservacion(@Valid @RequestBody CrearReservacionDTO crearReservacionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.creacionReservacionMapperRest.toReservacionResponseDTO(
                        crearReservacionInputPort.crearReservacion((crearReservacionDTO))
                ));
    }
}
