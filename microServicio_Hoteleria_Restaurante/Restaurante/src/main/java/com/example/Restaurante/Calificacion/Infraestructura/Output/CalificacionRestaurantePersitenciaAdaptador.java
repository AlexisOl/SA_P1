package com.example.Restaurante.Calificacion.Infraestructura.Output;

import com.example.Restaurante.Calificacion.Aplicacion.Ports.Output.CrearCalificacionRestauranteOutputPort;
import com.example.Restaurante.Calificacion.Dominio.CalificacionRestaurante;
import com.example.Restaurante.Calificacion.Infraestructura.Output.Entity.CalificacionRestauranteEntity;
import com.example.Restaurante.Calificacion.Infraestructura.Output.Mapper.CalificacionRestauranteMapper;
import com.example.Restaurante.Calificacion.Infraestructura.Output.Repository.CalificacionRestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class CalificacionRestaurantePersitenciaAdaptador implements CrearCalificacionRestauranteOutputPort {

    private final CalificacionRestauranteMapper calificacionRestauranteMapper;
    private final CalificacionRestauranteRepository calificacionRestauranteRepository;

    @Override
    @Transactional
    public CalificacionRestaurante createCalificacionRestaurante(CalificacionRestaurante calificacionRestaurante) {
        return this.calificacionRestauranteMapper.toCalificacionRestaurante(
                this.calificacionRestauranteRepository.save(
                        this.calificacionRestauranteMapper.toCalificacionRestauranteEntity(calificacionRestaurante)
                )
        );
    }
}
