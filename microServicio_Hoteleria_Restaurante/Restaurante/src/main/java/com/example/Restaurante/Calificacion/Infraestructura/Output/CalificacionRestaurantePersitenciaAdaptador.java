package com.example.Restaurante.Calificacion.Infraestructura.Output;

import com.example.Restaurante.Calificacion.Aplicacion.Ports.Output.CrearCalificacionRestauranteOutputPort;
import com.example.Restaurante.Calificacion.Aplicacion.Ports.Output.promedioValorarionPlatilloOutputPort;
import com.example.Restaurante.Calificacion.Dominio.CalificacionRestaurante;
import com.example.Restaurante.Calificacion.Infraestructura.Output.Entity.CalificacionRestauranteEntity;
import com.example.Restaurante.Calificacion.Infraestructura.Output.Mapper.CalificacionRestauranteMapper;
import com.example.Restaurante.Calificacion.Infraestructura.Output.Repository.CalificacionRestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
@AllArgsConstructor
public class CalificacionRestaurantePersitenciaAdaptador implements CrearCalificacionRestauranteOutputPort, promedioValorarionPlatilloOutputPort {

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

    @Override
    public Double promedioValoracion(UUID id) {
        return this.calificacionRestauranteRepository.promedioValoracionPlatillos(id);
    }
}
