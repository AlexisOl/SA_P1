package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Input.Rest;

import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Input.GenerarFacturaDetalladaInputPort;
import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Input.ListarFacturasDetalladasInputPort;
import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Service.GenerarFactura.GenerarFacturaDTO;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Input.Rest.Mapper.CreacionDetalleFacturaRestMapper;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Input.Rest.Model.Response.DetalleFacturaResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/detalleFactura")
public class DetalleFacturaRestAdapter {
    private final GenerarFacturaDetalladaInputPort generarFacturaDetalladaInputPort;
    private final ListarFacturasDetalladasInputPort listarFacturasDetalladasInputPort;
    private final CreacionDetalleFacturaRestMapper creacionDetalleFacturaRestMapper;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DetalleFacturaResponseDTO> crearDetalleFactura(@Valid @RequestBody GenerarFacturaDTO generarFacturaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.creacionDetalleFacturaRestMapper.toDetalleFacturaResponseDTO(
                        generarFacturaDetalladaInputPort.generarDetalleFactura((generarFacturaDTO))
                ));
    }

    @GetMapping()
    public List<DetalleFacturaResponseDTO> allDetalleFacturaHotel() {
        return  this.creacionDetalleFacturaRestMapper.toDetalleFacturaResponseDTO(this.listarFacturasDetalladasInputPort.listarFacturas());
    }
}
