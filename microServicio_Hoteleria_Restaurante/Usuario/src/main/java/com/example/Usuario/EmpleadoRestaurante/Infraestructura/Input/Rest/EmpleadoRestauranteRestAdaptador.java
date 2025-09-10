package com.example.Usuario.EmpleadoRestaurante.Infraestructura.Input.Rest;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.CrearEmpleadosHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.ListarEmpleadoEspecificoHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.ListarEmpleadosHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Service.CrearEmpleadoHotel.CrearEmpleadoDTO;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Input.Rest.Mapper.EmpleadoHotelRestMapper;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Input.Rest.Model.Output.ResponseEmpleadoHotelDTO;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Input.CrearEmpleadosRestauranteInputPort;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Service.CrearEmpleadoRestaurante.CrearEmpleadoRestauranteDTO;
import com.example.Usuario.EmpleadoRestaurante.Infraestructura.Input.Rest.Mapper.EmpleadoRestauranteRestMapper;
import com.example.Usuario.EmpleadoRestaurante.Infraestructura.Input.Rest.Model.Output.ResponseEmpleadoRestauranteDTO;
import com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Mapper.EmpleadoRestauranteMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/empleadoRestaurante")
public class EmpleadoRestauranteRestAdaptador {
    private final CrearEmpleadosRestauranteInputPort crearEmpleadosRestauranteInputPort;
    private final EmpleadoRestauranteRestMapper empleadoRestauranteMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public ResponseEntity<ResponseEmpleadoRestauranteDTO> crearEmpleadoRestaurante(@Valid @RequestBody CrearEmpleadoRestauranteDTO crearEmpleadoRestauranteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.empleadoRestauranteMapper.toResponseEmpleadoRestauranteDto(
                        crearEmpleadosRestauranteInputPort.crearEmpleadosHRestaurante((crearEmpleadoRestauranteDTO))
                ));
    }
}
