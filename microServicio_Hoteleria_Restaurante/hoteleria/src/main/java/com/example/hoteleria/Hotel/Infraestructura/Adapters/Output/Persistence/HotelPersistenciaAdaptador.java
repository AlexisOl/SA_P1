package com.example.hoteleria.Hotel.Infraestructura.Adapters.Output.Persistence;

import com.example.hoteleria.Hotel.Aplicacion.Ports.Output.BuscarIdHotelOutputPersitenciaPuerto;
import com.example.hoteleria.Hotel.Aplicacion.Ports.Output.HotelPersistenciaPuerto;
import com.example.hoteleria.Hotel.Dominio.Models.Hotel;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Output.Persistence.Mapper.HotelPersitenciaMapper;
import com.example.hoteleria.Hotel.Infraestructura.Adapters.Output.Persistence.Repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


// para un bean
@Component
@AllArgsConstructor
public class HotelPersistenciaAdaptador implements HotelPersistenciaPuerto, BuscarIdHotelOutputPersitenciaPuerto {

    private final HotelRepository hotelRepository;

    private final HotelPersitenciaMapper hotelMapper;

    @Override
    public Optional<Hotel> buscarPorId(Long id) {
        return this.hotelRepository.findById(id)
                .map(
                        hotelMapper::toHotel
                );
    }

    @Override
    public List<Hotel> buscarTodos() {
        return this.hotelMapper.toHotelList(
                hotelRepository.findAll()
        );
    }


    // se hace cambio al entity para guardarrr luego ya se cambia al Objeto de valor del dominio pero ya guardado
    @Override
    public Hotel save(Hotel hotel) {
        return this.hotelMapper.toHotel(
          this.hotelRepository.save(hotelMapper.toHotelEntity(hotel))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Hotel> buscarHotelId(Long idHotel) {
        return Optional.ofNullable(
                this.hotelMapper.toHotel(
                        this.hotelRepository.findHotelEntityById(idHotel)
                )
        );
    }
}
