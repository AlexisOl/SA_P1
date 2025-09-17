package com.example.Promociones.PromocionesHotel.Aplicacion.Service.ListarPromociones;

import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.ListarPromocionesInputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.CrearPromocionHotelOutputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.ExistePromocionHabitacionFechaOutputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.ListarPromocionesOutputPort;
import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.DTO.BuscarHabitacionResponseDTO;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.DTO.HotelDTO;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.HoteleriaFeign;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service

public class CasoUsoListarPromocionesGenerales implements ListarPromocionesInputPort {
    private final ListarPromocionesOutputPort  listarPromocionesOutputPort;
    private final HoteleriaFeign hoteleriaFeign;

    public CasoUsoListarPromocionesGenerales(ListarPromocionesOutputPort  listarPromocionesOutputPort,
                                      HoteleriaFeign hoteleriaFeign){
        this.listarPromocionesOutputPort=listarPromocionesOutputPort;
        this.hoteleriaFeign=hoteleriaFeign;
    }

    @Override
    public List<PromocionesHotel> listarPromocionesHotel(Long id) {
        //ver si exisre le hotel
        HotelDTO obtieneHotel = this.hoteleriaFeign.obtenerHotel(id).getBody();

        if(obtieneHotel == null){
            throw  new RuntimeException("No existe el hotel");
        }
        List<BuscarHabitacionResponseDTO> habitaciones = this.hoteleriaFeign.obtenerHabitacionHotel(id);

        if (habitaciones == null || habitaciones.isEmpty()) {
            throw new RuntimeException("El hotel no tiene habitaciones registradas");
        }

        List<UUID> idsHabitaciones = habitaciones.stream()
                .map(BuscarHabitacionResponseDTO::getId)
                .collect(Collectors.toList());

        return this.listarPromocionesOutputPort.listarPromocionesHotel(idsHabitaciones);
    }
}
