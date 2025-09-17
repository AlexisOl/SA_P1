package com.example.Promociones.PromocionesHotel.Aplicacion.Service.ListarPromoioneActual;

import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.LIstarPromocionesActualesHotelInputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.LIstarPromocionesActualesHotelOutputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.ListarPromocionesOutputPort;
import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.HoteleriaFeign;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class CasoUsoListarPromocionesActualesHotel implements LIstarPromocionesActualesHotelInputPort {

    private final LIstarPromocionesActualesHotelOutputPort listarPromocionesHotel;
    private final HoteleriaFeign hoteleriaFeign;

    public CasoUsoListarPromocionesActualesHotel(LIstarPromocionesActualesHotelOutputPort listarPromocionesHotel,
                                             HoteleriaFeign hoteleriaFeign){
        this.listarPromocionesHotel=listarPromocionesHotel;
        this.hoteleriaFeign=hoteleriaFeign;
    }
    @Override
    public PromocionesHotel listarPromocionesHotel(UUID id) {
        if(this.hoteleriaFeign.obtenerHabitacion(id)==null){
            throw new RuntimeException("No existe la habitacion");
        }


        return this.listarPromocionesHotel.listarPromocionesHotel(id, LocalDate.now());
    }
}
