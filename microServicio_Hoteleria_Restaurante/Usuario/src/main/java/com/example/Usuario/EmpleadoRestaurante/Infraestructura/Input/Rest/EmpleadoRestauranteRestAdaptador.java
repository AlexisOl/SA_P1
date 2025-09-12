package com.example.Usuario.EmpleadoRestaurante.Infraestructura.Input.Rest;

import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.CrearEmpleadosHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.ListarEmpleadoEspecificoHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Ports.Input.ListarEmpleadosHotelInputPort;
import com.example.Usuario.EmpleadoHotel.Aplicacion.Service.CrearEmpleadoHotel.CrearEmpleadoDTO;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Input.Rest.Mapper.EmpleadoHotelRestMapper;
import com.example.Usuario.EmpleadoHotel.Infraestructura.Input.Rest.Model.Output.ResponseEmpleadoHotelDTO;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Input.CrearEmpleadosRestauranteInputPort;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Input.GeneracionPagosRestauranteInputPort;
import com.example.Usuario.EmpleadoRestaurante.Aplicacion.Ports.Input.ListarEmpleadosRestauranteHotelInputPort;
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

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/empleadoRestaurante")
public class EmpleadoRestauranteRestAdaptador {
    private final CrearEmpleadosRestauranteInputPort crearEmpleadosRestauranteInputPort;
    private final EmpleadoRestauranteRestMapper empleadoRestauranteMapper;
    private final ListarEmpleadosRestauranteHotelInputPort listarEmpleadosRestauranteHotelInputPort;
    private final GeneracionPagosRestauranteInputPort generacionPagosRestauranteInputPort;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public ResponseEntity<ResponseEmpleadoRestauranteDTO> crearEmpleadoRestaurante(@Valid @RequestBody CrearEmpleadoRestauranteDTO crearEmpleadoRestauranteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.empleadoRestauranteMapper.toResponseEmpleadoRestauranteDto(
                        crearEmpleadosRestauranteInputPort.crearEmpleadosHRestaurante((crearEmpleadoRestauranteDTO))
                ));
    }

    @GetMapping("/restaurante/{id}")
    public List<ResponseEmpleadoRestauranteDTO> listadoEmpleadosPorHotel(@PathVariable UUID id) {
        return this.empleadoRestauranteMapper.toListResponseEmpleadoRestaurante(this.listarEmpleadosRestauranteHotelInputPort.listarEmpleadosPorRestaurante(id)) ;
    }


    @GetMapping("/pagos/{id}")
    public List<Object> pruebaPerdidas(@PathVariable UUID id) {
        return (this.generacionPagosRestauranteInputPort.perdidasPagosRestaurante(id)) ;
    }

}
