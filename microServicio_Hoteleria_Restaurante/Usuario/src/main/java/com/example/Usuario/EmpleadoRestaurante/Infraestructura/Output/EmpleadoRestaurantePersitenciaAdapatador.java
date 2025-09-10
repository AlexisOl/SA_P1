package com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output;

import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Output.CrearEmpleadoRestauranteOutputPort;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Output.ListarEmpleadosRestaurantePorRestauranteOutPutPort;
import com.example.Usuario.EmpleadoRestaurante.Dominio.EmpleadoRestaurante;
import com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Mapper.EmpleadoRestauranteMapper;
import com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Repository.EmpleadoRestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class EmpleadoRestaurantePersitenciaAdapatador implements CrearEmpleadoRestauranteOutputPort, ListarEmpleadosRestaurantePorRestauranteOutPutPort {
    private final EmpleadoRestauranteMapper empleadoRestauranteMapper;
    private final EmpleadoRestauranteRepository empleadoRestauranteRepository;

    @Override
    @Transactional
    public EmpleadoRestaurante crearEmpleadosHRestaurante(EmpleadoRestaurante crearEmpleadoRestauranteDTO) {
        return this.empleadoRestauranteMapper.toEmpleadoRestaurante(
                this.empleadoRestauranteRepository.save(
                        this.empleadoRestauranteMapper.toEmpleadoRestauranteEntity(crearEmpleadoRestauranteDTO)
                )
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmpleadoRestaurante> listarEmpleadosPorRestaurante(UUID id) {
        return this.empleadoRestauranteMapper.toListEmpleadoRestaurante(
                this.empleadoRestauranteRepository.findAllByRestauranteId(id)
        );
    }
}
