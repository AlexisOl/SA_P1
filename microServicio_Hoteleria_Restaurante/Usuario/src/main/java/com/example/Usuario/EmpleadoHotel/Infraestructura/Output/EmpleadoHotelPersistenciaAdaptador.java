package com.example.Usuario.EmpleadoHotel.Infraestructura.Output;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output.CrearEmpleadosHotelOutputPort;
import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Output.Mapper.EmpleadoHotelMapper;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Output.Repository.EmpleadoHotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmpleadoHotelPersistenciaAdaptador implements CrearEmpleadosHotelOutputPort {

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
}
