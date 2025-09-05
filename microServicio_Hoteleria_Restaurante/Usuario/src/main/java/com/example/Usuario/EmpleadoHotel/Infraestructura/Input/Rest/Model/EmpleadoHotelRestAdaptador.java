package com.example.Usuario.EmpleadoHotel.Infraestructura.Input.Rest.Model;


import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.CrearEmpleadosHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.ListarEmpleadoEspecificoHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.ListarEmpleadosHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Service.CrearEmpleadoHotel.CrearEmpleadoDTO;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Input.Rest.Mapper.EmpleadoHotelRestMapper;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Input.Rest.Model.Output.ResponseEmpleadoHotelDTO;
import com.example.Usuario.clientes.Aplicacion.Service.CrearUsuario.crearUsuarioDTO;
import com.example.Usuario.clientes.infraestructura.Adapters.Input.Rest.Model.Response.UsuarioResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/empleadoHotel")
public class EmpleadoHotelRestAdaptador {

    private final CrearEmpleadosHotelInputPort crearEmpleadosHotelInputPort;
    private final ListarEmpleadosHotelInputPort listarEmpleadosHotelInputPort;
    private final ListarEmpleadoEspecificoHotelInputPort  listarEmpleadoEspecificoHotelInputPort;
    private final EmpleadoHotelRestMapper empleadoHotelRestMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseEmpleadoHotelDTO> crearEmpleadoHotel(@Valid @RequestBody CrearEmpleadoDTO crearEmpleadoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.empleadoHotelRestMapper.toResponseEmpleadoHotel(
                        crearEmpleadosHotelInputPort.crearEmpleadosHotel((crearEmpleadoDTO))
                ));
    }

//    @GetMapping("/clientes/{id}")
//    public List<ResponseEmpleadoHotelDTO> listadoReservacionesPorCliente(@PathVariable UUID id) {
//        return this.creacionReservacionMapperRest.toListReservacionResponseDTO(this.listarReservacionesUsuarioInputPort.listarReservacionesUsuario(id)) ;
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseEmpleadoHotelDTO> listarReservacionEspecifica(@PathVariable UUID id) {
        return this.listarEmpleadoEspecificoHotelInputPort.ListarEmpleadoEspecificoHotel(id)
                .map(empleado -> ResponseEntity.ok(
                        this.empleadoHotelRestMapper.toResponseEmpleadoHotel(empleado)
                ))
                .orElse(ResponseEntity.notFound().build());
    }

}
