package com.example.Restaurante.Restaurante.Infraestructura.Output;

import com.example.Restaurante.Restaurante.Aplicacion.Ports.Output.CreacionRestauranteOutputPort;
import com.example.Restaurante.Restaurante.Aplicacion.Ports.Output.ListarRestaurantesEspecificosOutputPort;
import com.example.Restaurante.Restaurante.Aplicacion.Ports.Output.ListarRestaurantesOutputPort;
import com.example.Restaurante.Restaurante.Dominio.Restaurante;
import com.example.Restaurante.Restaurante.Infraestructura.Output.Mapper.RestauranteMapper;
import com.example.Restaurante.Restaurante.Infraestructura.Output.Repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class RestaurantePesistenciaAdaptador implements CreacionRestauranteOutputPort, ListarRestaurantesOutputPort, ListarRestaurantesEspecificosOutputPort {

    private final RestauranteMapper restauranteMapper;
    private final RestauranteRepository restauranteRepository;

    @Override
    @Transactional
    public Restaurante crearRestaurante(Restaurante restaurante) {
        return this.restauranteMapper.ToRestaurante(
                this.restauranteRepository.save(
                        this.restauranteMapper.toRestauranteEntity(restaurante)
                )
        );
    }

    @Override
    @Transactional(readOnly = true)
    public Restaurante listarRestaurantesEspecifico(UUID id) {
        return this.restauranteMapper.ToRestaurante(
                this.restauranteRepository.findById(id).get()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<Restaurante> listarRestaurantes() {
        return this.restauranteMapper.toRestaurantesList(this.restauranteRepository.findAll());
    }
}
