package com.example.Restaurante.Calificacion.Infraestructura.Output;

import com.example.Restaurante.Calificacion.Aplicacion.Ports.Output.CrearCalificacionRestauranteOutputPort;
import com.example.Restaurante.Calificacion.Aplicacion.Ports.Output.ListarComentarioPlatilloOutputPort;
import com.example.Restaurante.Calificacion.Aplicacion.Ports.Output.promedioValorarionPlatilloOutputPort;
import com.example.Restaurante.Calificacion.Dominio.CalificacionRestaurante;
import com.example.Restaurante.Calificacion.Infraestructura.Input.Rest.Mapper.CalificacionRestauranteRestMapper;
import com.example.Restaurante.Calificacion.Infraestructura.Input.Rest.Model.Output.ResponseCalificacionPlatilloDTO;
import com.example.Restaurante.Calificacion.Infraestructura.Output.Entity.CalificacionRestauranteEntity;
import com.example.Restaurante.Calificacion.Infraestructura.Output.Mapper.CalificacionRestauranteMapper;
import com.example.Restaurante.Calificacion.Infraestructura.Output.Repository.CalificacionRestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class CalificacionRestaurantePersitenciaAdaptador implements CrearCalificacionRestauranteOutputPort, promedioValorarionPlatilloOutputPort,
        ListarComentarioPlatilloOutputPort {

    private final CalificacionRestauranteMapper calificacionRestauranteMapper;
    private final CalificacionRestauranteRestMapper calificacionRestauranteRestMapper;
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

    @Override
    public List<CalificacionRestaurante> listarComentarioPlatillo(UUID id) {
        return this.calificacionRestauranteMapper.toCalificacionRestauranteList(
                this.calificacionRestauranteRepository.findAllByPlatillo_Id((id)
        ));
    }



}
