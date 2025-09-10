package com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output;

import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Output.CrearEmpleadoRestauranteOutputPort;
import com.example.Usuario.EmpleadoRestaurante.Dominio.EmpleadoRestaurante;
import com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Mapper.EmpleadoRestauranteMapper;
import com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Repository.EmpleadoRestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class EmpleadoRestaurantePersitenciaAdapatador implements CrearEmpleadoRestauranteOutputPort {
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
}
