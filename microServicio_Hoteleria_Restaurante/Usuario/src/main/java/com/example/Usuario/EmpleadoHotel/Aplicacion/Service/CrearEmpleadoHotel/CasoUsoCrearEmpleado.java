package com.example.Usuario.EmpleadoHotel.Aplicacion.Service.CrearEmpleadoHotel;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.CrearEmpleadosHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Output.CrearEmpleadosHotelOutputPort;
import com.example.Usuario.EmpleadoHotel.Dominio.EmpleadoHotel;
import com.example.Usuario.EmpleadoHotel.Dominio.ObjetosValor.FechaTrabajo;
import com.example.Usuario.Persona.Aplicacion.Ports.output.creacionPersonaOutputPersistenciaPuerto;
import com.example.Usuario.Persona.Dominio.Persona;
import com.example.Usuario.clientes.Aplicacion.Ports.Input.CreacionUsuarioInputPort;
import com.example.Usuario.clientes.Aplicacion.Ports.Output.CreacionUsuarioOutputPersitencePort;
import com.example.Usuario.clientes.Aplicacion.Service.CrearUsuario.crearUsuarioDTO;
import com.example.Usuario.clientes.Dominio.Model.TipoEmpleado;
import com.example.Usuario.clientes.Dominio.Model.Usuario;
import com.example.Usuario.clientes.infraestructura.Adapters.Output.Persistence.UsuarioPersistenceAdapter;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CasoUsoCrearEmpleado implements CrearEmpleadosHotelInputPort {

    private final CrearEmpleadosHotelOutputPort crearEmpleadosHotelOutputPort;
    //creacion de usuario
    private final CreacionUsuarioInputPort creacionUsuarioInputPort;
    //private final Buscar


    public CasoUsoCrearEmpleado(CrearEmpleadosHotelOutputPort crearEmpleadosHotelOutputPort,
                                CreacionUsuarioInputPort creacionUsuarioInputPort) {
        this.crearEmpleadosHotelOutputPort =  crearEmpleadosHotelOutputPort;
        this.creacionUsuarioInputPort = creacionUsuarioInputPort;
    }



    @Override
    @Transactional
    public EmpleadoHotel crearEmpleadosHotel(CrearEmpleadoDTO empleado) {

        Usuario usuario = this.creacionUsuarioInputPort.crearUsuario(
            new crearUsuarioDTO(
                  empleado.getUsername(),
                  empleado.getPassword(),
                  empleado.getCui(),
                    empleado.getNombre(),
                    empleado.getFechaNacimiento(),
                    empleado.getDireccion(),
                    empleado.getTelefono(),
                    empleado.getCorreo(),
                    "EMPLEADO"
            )
        );

        return this.crearEmpleadosHotelOutputPort.crearEmpleadosHotel(
               new EmpleadoHotel(
                       UUID.randomUUID(),
                       usuario.getPersona(),
                       1L,
                       empleado.getSalario(),
                       new FechaTrabajo(empleado.getFecha())

               )

        );

    }
}
