package com.example.Promociones.PromocionesHotel.Aplicacion.Service.CrearPromocionHotel;

import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.CrearPromocionHotelInputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.CrearPromocionHotelOutputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.ExistePromocionHabitacionFechaOutputPort;
import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.HoteleriaFeign;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CasoUsoCrearPromocion implements CrearPromocionHotelInputPort {

    private final CrearPromocionHotelOutputPort crearPromocionHotelOutputPort;
    private final HoteleriaFeign hoteleriaFeign;
    private final ExistePromocionHabitacionFechaOutputPort existePromocionHabitacionFechaOutputPort;


    public CasoUsoCrearPromocion(CrearPromocionHotelOutputPort crearPromocionHotelOutputPort,
                                 ExistePromocionHabitacionFechaOutputPort existePromocionHabitacionFechaOutputPort,
                                 HoteleriaFeign hoteleriaFeign){
        this.crearPromocionHotelOutputPort=crearPromocionHotelOutputPort;
        this.existePromocionHabitacionFechaOutputPort=existePromocionHabitacionFechaOutputPort;
        this.hoteleriaFeign=hoteleriaFeign;
    }
    @Override
    public PromocionesHotel crearPromocion(CrearPromocionDTO promocion) {
        // veri si existe la habitaicon

        if(this.hoteleriaFeign.obtenerHabitacion(promocion.getHabitacion())==null){
            throw new RuntimeException("No existe la habitacion");
        }
        //validar el feign de la existencia de promocion y evitar 2 promociones
        if (this.existePromocionHabitacionFechaOutputPort.existePromocionHabitacionFecha(promocion.getHabitacion(), promocion.getFecha_inicio(), promocion.getFecha_final())){
            throw new RuntimeException("Ya tiene registrada una promocion en ese periodo de tiempo");
        }
        //si todo bien lo guarda


        return this.crearPromocionHotelOutputPort.crearPromocion(
                new PromocionesHotel(
                        UUID.randomUUID(),
                        promocion.getCantidad_descuento(),
                        promocion.getFecha_inicio(),
                        promocion.getFecha_final(),
                        promocion.getHabitacion()
                )
        );
    }
}
