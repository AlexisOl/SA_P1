package com.example.hoteleria.Hotel.Aplicacion.Service.BuscarHotelId;

import com.example.hoteleria.Hotel.Aplicacion.Ports.In.BuscarPorIdInputPort;
import com.example.hoteleria.Hotel.Aplicacion.Ports.Output.BuscarIdHotelOutputPersitenciaPuerto;
import com.example.hoteleria.Hotel.Aplicacion.Ports.Output.HotelPersistenciaPuerto;
import com.example.hoteleria.Hotel.Dominio.Exception.HotelNoEncontrado;
import com.example.hoteleria.Hotel.Dominio.Models.Hotel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CasoUsoBuscarHotelId implements BuscarPorIdInputPort {
    @Autowired
    private BuscarIdHotelOutputPersitenciaPuerto persistenciaPuerto;
    @Override
    public Hotel buscarPorId(Long id) {
        return persistenciaPuerto.buscarHotelId(id).orElseThrow(
                () -> new HotelNoEncontrado("Hotel no encontrado")
        );
    }
}
