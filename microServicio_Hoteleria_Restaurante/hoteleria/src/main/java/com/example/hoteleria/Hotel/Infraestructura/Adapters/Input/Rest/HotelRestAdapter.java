package com.example.hoteleria.Hotel.Infraestructura.Adapters.Input.Rest;


import com.example.hoteleria.Hotel.Aplicacion.Ports.In.BuscarPorIdInputPort;
import com.example.hoteleria.Hotel.Aplicacion.Ports.In.BuscarTodoInputPort;
import com.example.hoteleria.Hotel.Aplicacion.Ports.In.CrearHotelInputPort;
import com.example.hoteleria.Hotel.Aplicacion.Ports.In.HotelServicioPuerto;
import com.example.hoteleria.Hotel.Dominio.Models.Hotel;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Input.Rest.Mapper.HotelRestMapper;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Input.Rest.Model.Request.CreacionHotelRequest;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Input.Rest.Model.Response.HotelResponse;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Output.Persistence.Repository.HotelRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/hotel")
public class HotelRestAdapter {

    private final HotelRestMapper restMapper;
    private final HotelServicioPuerto servicioPuerto;
    //private final BuscarTodoInputPort buscarTodoInputPort;
    //private final CrearHotelInputPort crearHotelInputPort;
    private final BuscarPorIdInputPort  buscarPorIdInputPort;


    @GetMapping()
    public List<HotelResponse> allHoteles() {
        return  this.restMapper.toHotelResponseList(this.servicioPuerto.buscarTodos());
    }

    @GetMapping("{id}")
    public HotelResponse findByIdHotel(@PathVariable Long id) {
        return  this.restMapper.toHotelResponseMapper(this.buscarPorIdInputPort.buscarPorId(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<HotelResponse> createHotel(@Valid @RequestBody CreacionHotelRequest hotel) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.restMapper.toHotelResponseMapper(
                        servicioPuerto.save(restMapper.toHotelMapper(hotel))
                ));
    }
}
