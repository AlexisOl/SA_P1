package com.example.Usuario.EmpleadoHotel.Infraestructura.Output;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output.*;
import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Output.Mapper.EmpleadoHotelMapper;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Output.Repository.EmpleadoHotelRepository;
import com.example.Usuario.Persona.Dominio.Persona;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class EmpleadoHotelPersistenciaAdaptador implements CrearEmpleadosHotelOutputPort,
        ListarEmpleadosHotelOutputPort, ListarEmpleadoEspecificoHotelOutputPort, ListarEmpleadosPorHotelOutputPort,
        GeneracionPagosHotelOutputPort,
        EmpleadoHotelPorCuiOutputport {

    private EmpleadoHotelRepository empleadoHotelRepository;
    private EmpleadoHotelMapper empleadoHotelMapper;


    @Override
    public EmpleadoHotel crearEmpleadosHotel(EmpleadoHotel empleado) {
        return this.empleadoHotelMapper.toEmpleadoHotel(
                this.empleadoHotelRepository.save(
                        this.empleadoHotelMapper.toEmpleadoHotelEntity(empleado)
                )
        );
    }

    @Override
    public Optional<EmpleadoHotel> ListarEmpleadoEspecificoHotel(UUID id) {
        return Optional.ofNullable(
                this.empleadoHotelMapper.toEmpleadoHotel(
                        this.empleadoHotelRepository.findById((id)
                )
                ));
    }

    @Override
    public List<EmpleadoHotel> listarEmpleadosHotel() {
        return this.empleadoHotelMapper.toListEmpleadoHotel(this.empleadoHotelRepository.findAll());
    }

    @Override
    public List<EmpleadoHotel> listarEmpleadosPorHotel(Long id) {
        return this.empleadoHotelMapper.toListEmpleadoHotel(
                this.empleadoHotelRepository.findAllByIdhotel((id))
        );
    }

    @Override
    public EmpleadoHotel obtenerEmpleaado(Persona persona) {
        return this.empleadoHotelMapper.toEmpleadoHotel(
                this.empleadoHotelRepository.findByPersona_Cui(persona.getCui())
        );
    }

    @Override
    public List<Object> perdidasPagosHotel(Long id) {
        return this.empleadoHotelRepository.estimarPerdidaPagosEmpleado(id);
    }
}
