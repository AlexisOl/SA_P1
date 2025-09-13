package com.example.hoteleria.Hotel.Aplicacion.Ports.In;

import com.example.hoteleria.Hotel.Dominio.Models.Hotel;

public interface BuscarPorIdInputPort {
    Hotel buscarPorId(Long id);

}
