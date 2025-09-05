package com.example.Usuario.EmpleadoHotel.Infraestructura.Input.Rest.Model;


import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.CrearEmpleadosHotelInputPort;
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

@RestController
@AllArgsConstructor
@RequestMapping("/empleadoHotel")
public class EmpleadoHotelRestAdaptador {

    private final CrearEmpleadosHotelInputPort crearEmpleadosHotelInputPort;
    private final EmpleadoHotelRestMapper empleadoHotelRestMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseEmpleadoHotelDTO> crearEmpleadoHotel(@Valid @RequestBody CrearEmpleadoDTO crearEmpleadoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.empleadoHotelRestMapper.toResponseEmpleadoHotel(
                        crearEmpleadosHotelInputPort.crearEmpleadosHotel((crearEmpleadoDTO))
                ));
    }
}
