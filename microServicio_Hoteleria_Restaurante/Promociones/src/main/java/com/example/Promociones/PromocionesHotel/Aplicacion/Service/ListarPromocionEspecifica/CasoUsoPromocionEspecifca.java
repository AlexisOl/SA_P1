package com.example.Promociones.PromocionesHotel.Aplicacion.Service.ListarPromocionEspecifica;

import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.ListarPromocionEspecificaInputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.LIstarPromocionesActualesHotelOutputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.ListarPromocionEspecificaOutputPort;
import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.HoteleriaFeign;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

public class CasoUsoPromocionEspecifca implements ListarPromocionEspecificaInputPort {
    private final ListarPromocionEspecificaOutputPort listarPromocionesHotel;

    public CasoUsoPromocionEspecifca(ListarPromocionEspecificaOutputPort listarPromocionesHotel
                                                 ){
        this.listarPromocionesHotel=listarPromocionesHotel;

    }
    @Override
    public PromocionesHotel ListarPromocionEspecifica(UUID id) {
        return this.listarPromocionesHotel.ListarPromocionEspecifica(id);
    }
}
