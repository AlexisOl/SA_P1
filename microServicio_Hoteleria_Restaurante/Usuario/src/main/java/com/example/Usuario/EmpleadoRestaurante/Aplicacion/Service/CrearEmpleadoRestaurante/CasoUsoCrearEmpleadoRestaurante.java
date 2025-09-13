package com.example.Usuario.EmpleadoRestaurante.Aplicacion.Service.CrearEmpleadoRestaurante;


import com.example.Usuario.EmpleadoRestaurante.Dominio.ObjetosValor.FechaTrabajo;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Input.CrearEmpleadosRestauranteInputPort;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Output.CrearEmpleadoRestauranteOutputPort;
import com.example.Usuario.EmpleadoRestaurante.Dominio.EmpleadoRestaurante;
import com.example.Usuario.clientes.Aplicacion.Ports.Input.CreacionUsuarioInputPort;
import com.example.Usuario.clientes.Aplicacion.Service.CrearUsuario.crearUsuarioDTO;
import com.example.Usuario.clientes.Dominio.Model.Usuario;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CasoUsoCrearEmpleadoRestaurante implements CrearEmpleadosRestauranteInputPort {

    private final CrearEmpleadoRestauranteOutputPort  crearEmpleadoRestauranteOutputPort;
    //creacion de usuario
    private final CreacionUsuarioInputPort creacionUsuarioInputPort;

    public  CasoUsoCrearEmpleadoRestaurante(CrearEmpleadoRestauranteOutputPort  crearEmpleadoRestauranteOutputPort,
                                            CreacionUsuarioInputPort creacionUsuarioInputPort) {
        this.crearEmpleadoRestauranteOutputPort = crearEmpleadoRestauranteOutputPort;
        this.creacionUsuarioInputPort=creacionUsuarioInputPort;
    }
    @Override
    public EmpleadoRestaurante crearEmpleadosHRestaurante(CrearEmpleadoRestauranteDTO crearEmpleadoRestauranteDTO) {

        Usuario usuario = this.creacionUsuarioInputPort.crearUsuario(
                new crearUsuarioDTO(
                        crearEmpleadoRestauranteDTO.getUsername(),
                        crearEmpleadoRestauranteDTO.getPassword(),
                        crearEmpleadoRestauranteDTO.getCui(),
                        crearEmpleadoRestauranteDTO.getNombre(),
                        crearEmpleadoRestauranteDTO.getFechaNacimiento(),
                        crearEmpleadoRestauranteDTO.getDireccion(),
                        crearEmpleadoRestauranteDTO.getTelefono(),
                        crearEmpleadoRestauranteDTO.getCorreo(),
                        "EMPLEADO"
                )
        );

        return this.crearEmpleadoRestauranteOutputPort.crearEmpleadosHRestaurante(
                new EmpleadoRestaurante(
                        UUID.randomUUID(),
                        usuario.getPersona(),
                        crearEmpleadoRestauranteDTO.getRestauranteId(),
                        crearEmpleadoRestauranteDTO.getSalario(),
                        new FechaTrabajo(crearEmpleadoRestauranteDTO.getFecha())
                )
        );
    }
}
