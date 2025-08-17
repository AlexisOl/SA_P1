package com.example.hoteleria.Hotel.Aplicacion.Service;

import com.example.hoteleria.Hotel.Aplicacion.Ports.In.HotelServicioPuerto;
import com.example.hoteleria.Hotel.Aplicacion.Ports.Output.HotelPersistenciaPuerto;
import com.example.hoteleria.Hotel.Dominio.Exception.HotelNoEncontrado;
import com.example.hoteleria.Hotel.Dominio.Models.Hotel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor

public class HotelServicio implements HotelServicioPuerto {

    @Autowired
    private HotelPersistenciaPuerto persistenciaPuerto;

    @Override
    public Hotel buscarPorId(Long id) {
        return persistenciaPuerto.buscarPorId(id).orElseThrow(
                () -> new HotelNoEncontrado("Hotel no encontrado")
        );
    }

    @Override
    public List<Hotel> buscarTodos() {
        return persistenciaPuerto.buscarTodos();
    }

    @Override
    public Hotel save(Hotel hotel) {
        return persistenciaPuerto.save(hotel);
    }

    @Override
    public Hotel update(Hotel hotel, Long id) {
        return persistenciaPuerto.buscarPorId(id).map(
                hotelEncotrado -> {
                    hotelEncotrado.setDireccion(hotel.getDireccion());
                    hotelEncotrado.setNombre(hotel.getNombre());
                    hotelEncotrado.setTelefono(hotel.getTelefono());

                    return  persistenciaPuerto.save(hotelEncotrado);
                }
        ).orElseThrow(
                () -> new HotelNoEncontrado("Hotel no encontrado")
        );
    }
}
