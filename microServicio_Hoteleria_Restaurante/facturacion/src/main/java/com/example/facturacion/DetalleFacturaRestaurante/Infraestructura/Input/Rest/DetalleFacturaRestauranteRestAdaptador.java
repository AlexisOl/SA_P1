package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Input.Rest;

import com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Ports.Input.CrearDetlleFacturaInputPort;
import com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Ports.Input.ListarDetallaFacturaRestauranteEspecificaInputPort;
import com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Service.CrearDetalleFactura.CrearDetlleFacturaDTO;
import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Input.Rest.Mapper.DetalleFacturaRestauranteRestMapper;
import com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Input.Rest.Model.Output.ResponseDetalleFacturaRestauranteDTO;
import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Service.GenerarFactura.GenerarFacturaDTO;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Input.Rest.Model.Response.DetalleFacturaResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/detalleFacturaRestaurante")
public class DetalleFacturaRestauranteRestAdaptador {

    private final CrearDetlleFacturaInputPort crearDetlleFacturaInputPort;
    private final DetalleFacturaRestauranteRestMapper detalleFacturaRestauranteRestMapper;
    private final ListarDetallaFacturaRestauranteEspecificaInputPort listarDetallaFacturaRestauranteEspecificaInputPort;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseDetalleFacturaRestauranteDTO> crearDetalleFactura(@Valid @RequestBody CrearDetlleFacturaDTO detlleFacturaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.detalleFacturaRestauranteRestMapper.toDetalleFacturaRestauranteDTO(
                        crearDetlleFacturaInputPort.createDetalleFacturaRestaurante((detlleFacturaDTO))
                ));
    }

    @GetMapping("/{id}")
    public List<ResponseDetalleFacturaRestauranteDTO> ListarDetalleFactura(@PathVariable UUID id) {
        return  this.detalleFacturaRestauranteRestMapper.toListDetalleFacturaRestauranteDTO(this.listarDetallaFacturaRestauranteEspecificaInputPort.ListarDetalleFactura(id));
    }
}
