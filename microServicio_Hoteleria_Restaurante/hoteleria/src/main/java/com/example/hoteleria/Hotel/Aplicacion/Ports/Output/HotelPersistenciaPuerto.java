package com.example.hoteleria.Hotel.Aplicacion.Ports.Output;

import com.example.hoteleria.Hotel.Dominio.Models.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelPersistenciaPuerto {

    // metodos de almacenamiento de dominio
    Optional<Hotel> buscarPorId(Long id);
    List<Hotel> buscarTodos();
    Hotel save(Hotel hotel);



}
