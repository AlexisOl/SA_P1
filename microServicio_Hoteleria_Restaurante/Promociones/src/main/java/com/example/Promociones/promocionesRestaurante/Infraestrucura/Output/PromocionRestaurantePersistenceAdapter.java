package com.example.Promociones.promocionesRestaurante.Infraestrucura.Output;

import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Output.*;
import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;
import com.example.Promociones.promocionesRestaurante.Infraestrucura.Output.Mapper.PromocionRestauranteMapper;
import com.example.Promociones.promocionesRestaurante.Infraestrucura.Output.Repository.PromocionRestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Component
@AllArgsConstructor
public class PromocionRestaurantePersistenceAdapter implements CrearPromocionRestauranteOutputPort, ExistePromocionRestauranteFechaOutputPort,
        ListarPromocionesEspecificasRestauranteOutputPort, ListarPromocionesRestauranteOutputPort, ListarPromocionesRestauranteActualesOutputPort {
    private final PromocionRestauranteRepository promocionRestauranteRepository;
    private final PromocionRestauranteMapper promocionRestauranteMapper;
    @Override
    public PromocionRestaurante crearPromocion(PromocionRestaurante promocion) {
        return this.promocionRestauranteMapper.toPromocionRestaurante(
                this.promocionRestauranteRepository.save(
                        this.promocionRestauranteMapper.toPromocionRestauranteEntity(promocion)
                )
        );
    }

    @Override
    public boolean existePromocionPlatilloFecha(UUID platillo, LocalDate fechaInicio, LocalDate fechaFinal) {
        return this.promocionRestauranteRepository.existsOverlappingPromotion( platillo, fechaInicio,fechaFinal);

    }

    @Override
    public PromocionRestaurante ListarPromocionEspecificaRestaurante(UUID id) {
        return this.promocionRestauranteMapper.toPromocionRestaurante(
                this.promocionRestauranteRepository.findById(id).orElse(null)
        );
    }


    //actual
    @Override
    public PromocionRestaurante listarPromocionesRestaurante(UUID id, LocalDate fecha) {
        return this.promocionRestauranteMapper.toPromocionRestaurante(
                this.promocionRestauranteRepository.findByPlatilloAndFechaInicioLessThanEqualAndFechaFinalGreaterThanEqual(id, fecha, fecha)
        );
    }

    @Override
    public List<PromocionRestaurante> listarPromocionesRestaurante(List<UUID> id) {
        return this.promocionRestauranteMapper.toPromocionRestauranteList(
                this.promocionRestauranteRepository.findAllByPlatilloIn(id)
        );
    }
}
