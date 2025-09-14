package com.example.Promociones.PromocionesHotel.Infraestrucura.Output;


import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.*;
import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Output.Mapper.PromocionHotelMapper;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Output.Repository.PromocionHotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class PromocionHotelPersitenciaAdaptador implements CrearPromocionHotelOutputPort, ExistePromocionHabitacionFechaOutputPort,
        ListarPromocionesOutputPort, LIstarPromocionesActualesHotelOutputPort, ListarPromocionEspecificaOutputPort {
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
        return this.promocionHotelRepository.existsOverlappingPromotion( habiacion, fechaInicio,fechaFinal);
    }

    @Override
    public List<PromocionesHotel> listarPromocionesHotel(List<UUID> id) {
        return this.promocionHotelMapper.toPromocionesHotelList(
                this.promocionHotelRepository.findAllByHabitacionIn(id)
        );
    }

    @Override
    public PromocionesHotel listarPromocionesHotel(UUID id, LocalDate fecha) {
        return this.promocionHotelMapper.toPromocionesHotel(
                this.promocionHotelRepository.findByHabitacionAndFechaInicioLessThanEqualAndFechaFinalGreaterThanEqual(id, fecha, fecha)
        );
    }

    @Override
    public PromocionesHotel ListarPromocionEspecifica(UUID id) {
           return this.promocionHotelMapper.toPromocionesHotel(
                this.promocionHotelRepository.findById(id).orElse(null)
        );
    }
}
