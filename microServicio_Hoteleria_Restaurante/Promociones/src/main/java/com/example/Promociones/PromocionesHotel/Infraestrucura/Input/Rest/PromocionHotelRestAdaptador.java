package com.example.Promociones.PromocionesHotel.Infraestrucura.Input.Rest;

import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.CrearPromocionHotelInputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.LIstarPromocionesActualesHotelInputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.ListarPromocionEspecificaInputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.ListarPromocionesInputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Service.CrearPromocionHotel.CrearPromocionDTO;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Input.Rest.MapperRest.PromocionHotelRestMapper;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Input.Rest.Model.Response.ResponsePromocionHotelDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/promocionHotel")
public class PromocionHotelRestAdaptador {

    private final CrearPromocionHotelInputPort crearPromocionHotelInputPort;
    private final PromocionHotelRestMapper promocionHotelRestMapper;
    private final ListarPromocionesInputPort listarPromocionesInputPort;
    private final LIstarPromocionesActualesHotelInputPort lIstarPromocionesActualesHotelInputPort;
    private final ListarPromocionEspecificaInputPort listarPromocionEspecificaInputPort;


//    @GetMapping("{hotel_id}")
//    public List<ListarHabitacionesResponseDTO> allHabitacionesPorHotel(@Valid @PathVariable Long hotel_id) {
//        ListarHabitacionesPorHotelDTO listarHabitacionesPorHotelDTO = new ListarHabitacionesPorHotelDTO(hotel_id);
//        return  this.creacionHabitacionRestMapper.toHabitacionesListaResponse(this.listarHabitacionesInputPort.listarHabitaciones(listarHabitacionesPorHotelDTO));
//    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponsePromocionHotelDTO> crearPromocion(@Valid @RequestBody CrearPromocionDTO crearHabitacionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.promocionHotelRestMapper.toResponsePromocionHotelDto(
                        crearPromocionHotelInputPort.crearPromocion((crearHabitacionDTO))
                ));
    }

    @GetMapping("/hotel/{habitacionId}")
    public List<ResponsePromocionHotelDTO> obtenerPromocionesPorHotel(@PathVariable Long habitacionId ) {
        return this.promocionHotelRestMapper.toResponsePromocionHotelDtoList(
                listarPromocionesInputPort.listarPromocionesHotel(habitacionId)

        );
    }


    @GetMapping("/actualEspecifica/{habitacion_id}")
    public ResponsePromocionHotelDTO onbtenerPromocionActual(@Valid @PathVariable UUID habitacion_id) {
        return this.promocionHotelRestMapper.toResponsePromocionHotelDto(
                lIstarPromocionesActualesHotelInputPort.listarPromocionesHotel(habitacion_id)

        );
    }
    @GetMapping("/{id}")
    public ResponsePromocionHotelDTO onbtenerPromocionEspecifica(@Valid @PathVariable UUID id) {
        return this.promocionHotelRestMapper.toResponsePromocionHotelDto(
                listarPromocionEspecificaInputPort.ListarPromocionEspecifica(id)

        );
    }
}
