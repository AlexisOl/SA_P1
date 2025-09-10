package com.example.Usuario.EmpleadoHotel.Infraestructura.Output;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output.CrearEmpleadosHotelOutputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output.ListarEmpleadoEspecificoHotelOutputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output.ListarEmpleadosHotelOutputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output.ListarEmpleadosPorHotelOutputPort;
import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Output.Mapper.EmpleadoHotelMapper;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Output.Repository.EmpleadoHotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class EmpleadoHotelPersistenciaAdaptador implements CrearEmpleadosHotelOutputPort,
        ListarEmpleadosHotelOutputPort, ListarEmpleadoEspecificoHotelOutputPort, ListarEmpleadosPorHotelOutputPort {

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
}
