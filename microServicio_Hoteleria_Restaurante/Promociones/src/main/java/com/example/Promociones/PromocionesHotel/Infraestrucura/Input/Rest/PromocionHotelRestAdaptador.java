package com.example.Promociones.PromocionesHotel.Infraestrucura.Input.Rest;

import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.CrearPromocionHotelInputPort;
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


//    @GetMapping("/habitacion/{habitacion_id}")
//    public BuscarHabitacionResponseDTO obtenerHabitacion(@Valid @PathVariable UUID habitacion_id) {
//        Habitacion prueba = this.buscarHabitacionInputPort.buscarHabitacion(habitacion_id);
//        System.out.println(prueba.getId()+" - "+prueba.getPrecio()+ "-- "+ prueba.getTipoHabitacion());
//        return  this.creacionHabitacionRestMapper.toBuscarHabitacionResponse(this.buscarHabitacionInputPort.buscarHabitacion(habitacion_id));
//    }
}
