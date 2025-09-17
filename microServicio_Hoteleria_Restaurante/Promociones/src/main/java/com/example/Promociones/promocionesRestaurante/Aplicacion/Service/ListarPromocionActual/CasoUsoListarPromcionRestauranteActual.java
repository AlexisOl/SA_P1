package com.example.Promociones.promocionesRestaurante.Aplicacion.Service.ListarPromocionActual;

import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.LIstarPromocionesActualesHotelOutputPort;
import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.HoteleriaFeign;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Input.LIstarPromocionActualesRestauranteInputPort;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Output.ListarPromocionesRestauranteActualesOutputPort;
import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;
import com.example.Promociones.promocionesRestaurante.Infraestrucura.Feigns.RestauranteFeign;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service

public class CasoUsoListarPromcionRestauranteActual implements LIstarPromocionActualesRestauranteInputPort {
    private final ListarPromocionesRestauranteActualesOutputPort listarPromocionesRestauranteActualesOutputPort;
    private final RestauranteFeign restauranteFeign;

    public CasoUsoListarPromcionRestauranteActual(ListarPromocionesRestauranteActualesOutputPort listarPromocionesRestauranteActualesOutputPort,
                                                  RestauranteFeign restauranteFeign){
        this.listarPromocionesRestauranteActualesOutputPort=listarPromocionesRestauranteActualesOutputPort;
        this.restauranteFeign=restauranteFeign;
    }

    @Override
    public PromocionRestaurante ListarPromocionActual(UUID id) {
        if(this.restauranteFeign.obtenerPlatillo(id).getId()==null){
            throw new RuntimeException("No existe el platillo");
        }

        System.out.println(this.restauranteFeign.obtenerPlatillo(id).getNombre());


        return this.listarPromocionesRestauranteActualesOutputPort.listarPromocionesRestaurante(id, LocalDate.now());
    }
}
