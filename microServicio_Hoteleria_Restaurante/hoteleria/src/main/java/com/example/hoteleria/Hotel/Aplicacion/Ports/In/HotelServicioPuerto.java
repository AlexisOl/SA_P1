package com.example.hoteleria.Hotel.Aplicacion.Ports.In;

import com.example.hoteleria.Hotel.Dominio.Models.Hotel;

import java.util.List;

public interface HotelServicioPuerto {

    Hotel buscarPorId(Long id);

    List<Hotel> buscarTodos();

    Hotel save (Hotel hotel);

    Hotel update(Hotel hotel, Long id);

}
