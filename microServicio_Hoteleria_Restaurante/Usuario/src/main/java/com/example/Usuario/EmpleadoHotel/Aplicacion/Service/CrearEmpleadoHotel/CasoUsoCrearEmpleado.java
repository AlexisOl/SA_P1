package com.example.Usuario.EmpleadoHotel.Aplicacion.Service.CrearEmpleadoHotel;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.CrearEmpleadosHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output.CrearEmpleadosHotelOutputPort;
import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import com.example.Usuario.EmpleadoHotel.Dominio.ObjetosValor.FechaTrabajo;
import com.example.Usuario.Persona.Aplicacion.Ports.output.creacionPersonaOutputPersistenciaPuerto;
import com.example.Usuario.Persona.Dominio.Persona;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CasoUsoCrearEmpleado implements CrearEmpleadosHotelInputPort {

    private final CrearEmpleadosHotelOutputPort crearEmpleadosHotelOutputPort;
    private final creacionPersonaOutputPersistenciaPuerto creacionPersonaOutputPersistenciaPuerto;
    //private final Buscar


    public CasoUsoCrearEmpleado(CrearEmpleadosHotelOutputPort crearEmpleadosHotelOutputPort,
                                creacionPersonaOutputPersistenciaPuerto creacionPersonaOutputPersistenciaPuerto) {
        this.crearEmpleadosHotelOutputPort =  crearEmpleadosHotelOutputPort;
        this.creacionPersonaOutputPersistenciaPuerto = creacionPersonaOutputPersistenciaPuerto;
    }



    @Override
    public EmpleadoHotel crearEmpleadosHotel(CrearEmpleadoDTO empleado) {

        Persona persona = this.creacionPersonaOutputPersistenciaPuerto.creacionPersona(
                new Persona(
                        empleado.getCui(),
                        empleado.getNombre(),
                        empleado.getFechaNacimiento(),
                        empleado.getDireccion(),
                        empleado.getTelefono(),
                        empleado.getCorreo()
                )
        );

        return this.crearEmpleadosHotelOutputPort.crearEmpleadosHotel(
               new EmpleadoHotel(
                       UUID.randomUUID(),
                       persona,
                       1L,
                       empleado.getSalario(),
                       new FechaTrabajo(empleado.getFecha())

               )

        );

    }
}
