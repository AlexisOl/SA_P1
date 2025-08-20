package com.example.hoteleria.Hotel.Aplicacion.Ports.Output;

import com.example.hoteleria.Hotel.Dominio.Models.Hotel;

import java.util.Optional;
import java.util.UUID;

public interface BuscarIdHotelOutputPersitenciaPuerto {

        Optional<Hotel> buscarHotelId(Long idHotel);
}
