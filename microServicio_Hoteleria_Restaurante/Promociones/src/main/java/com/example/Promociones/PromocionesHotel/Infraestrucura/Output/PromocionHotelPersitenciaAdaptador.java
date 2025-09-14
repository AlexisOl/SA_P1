package com.example.Promociones.PromocionesHotel.Infraestrucura.Output;


import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.CrearPromocionHotelOutputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.ExistePromocionHabitacionFechaOutputPort;
import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Output.Mapper.PromocionHotelMapper;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Output.Repository.PromocionHotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
@AllArgsConstructor
public class PromocionHotelPersitenciaAdaptador implements CrearPromocionHotelOutputPort, ExistePromocionHabitacionFechaOutputPort {
    private final PromocionHotelRepository promocionHotelRepository;
    private final PromocionHotelMapper promocionHotelMapper;
    @Override
    public PromocionesHotel crearPromocion(PromocionesHotel promocion) {
        return this.promocionHotelMapper.toPromocionesHotel(
                this.promocionHotelRepository.save(
                        this.promocionHotelMapper.toPromocionHotelEntity(promocion)
                )
        );
    }

    @Override
    public boolean existePromocionHabitacionFecha(UUID habiacion, LocalDate fechaInicio, LocalDate fechaFinal) {
        return this.promocionHotelRepository.existsByHabitacionAndFecha_inicioLessThanEqualAndFecha_finalGreaterThanEqual( habiacion, fechaInicio,fechaFinal);
    }
}
