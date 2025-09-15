package com.example.Promociones.promocionesRestaurante.Aplicacion.Service.CasoUsoCrearPromocion;

import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.CrearPromocionHotelOutputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.ExistePromocionHabitacionFechaOutputPort;
import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.HoteleriaFeign;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Input.CrearPromocionRestauranteInputPort;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Output.CrearPromocionRestauranteOutputPort;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Output.ExistePromocionRestauranteFechaOutputPort;
import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;
import com.example.Promociones.promocionesRestaurante.Infraestrucura.Feigns.RestauranteFeign;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service

public class CasoUsoCrearPromocionRestaurante implements CrearPromocionRestauranteInputPort {

    private final CrearPromocionRestauranteOutputPort crearPromocionRestauranteOutputPort;
    private final RestauranteFeign restauranteFeign;
    private final ExistePromocionRestauranteFechaOutputPort existePromocionRestauranteFechaOutputPort;


    public CasoUsoCrearPromocionRestaurante(CrearPromocionRestauranteOutputPort crearPromocionRestauranteOutputPort,
                                 ExistePromocionRestauranteFechaOutputPort existePromocionRestauranteFechaOutputPort,
                                 RestauranteFeign restauranteFeign){
        this.crearPromocionRestauranteOutputPort=crearPromocionRestauranteOutputPort;
        this.existePromocionRestauranteFechaOutputPort=existePromocionRestauranteFechaOutputPort;
        this.restauranteFeign=restauranteFeign;


    }
    @Override
    public PromocionRestaurante crearPromocion(CrearPromocionRestauranteDTO promocion) {
        // veri si existe la habitaicon

        if(this.restauranteFeign.obtenerPlatillo(promocion.getPlatillo())==null){
            throw new RuntimeException("No existe el platillo");
        }
        //validar el feign de la existencia de promocion y evitar 2 promociones
        if (this.existePromocionRestauranteFechaOutputPort.existePromocionPlatilloFecha(promocion.getPlatillo(), promocion.getFechaInicio(), promocion.getFechaFinal())){
            throw new RuntimeException("Ya tiene registrada una promocion en ese periodo de tiempo");
        }
        //si todo bien lo guarda


        return this.crearPromocionRestauranteOutputPort.crearPromocion(
                new PromocionRestaurante(
                        UUID.randomUUID(),
                        promocion.getCantidad_descuento(),
                        promocion.getFechaInicio(),
                        promocion.getFechaFinal(),
                        promocion.getPlatillo()
                )
        );
    }
}
