package com.example.Restaurante.Platillos.Infraestructura.Input.Rest;

import com.example.Restaurante.Platillos.Aplicacion.Ports.Input.CrearPlatilloInputPort;
import com.example.Restaurante.Platillos.Aplicacion.Ports.Input.ListarPlatilloEspecificoInputPort;
import com.example.Restaurante.Platillos.Aplicacion.Ports.Input.ListarPlatillosGlobalesInputPort;
import com.example.Restaurante.Platillos.Aplicacion.Ports.Input.ListarPlatillosInputPort;
import com.example.Restaurante.Platillos.Aplicacion.Service.CasoUsoCrearPlatillo.CrearPlatilloDTO;
import com.example.Restaurante.Platillos.Dominio.Platillos;
import com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Mapper.PlatillosRestMapper;
import com.example.Restaurante.Platillos.Infraestructura.Input.Rest.Model.Output.ResponsePlatillosDTO;
import com.example.Restaurante.Restaurante.Aplicacion.Service.CasoUsoCreacionRestaurante.CreacionRestauranteDTO;
import com.example.Restaurante.Restaurante.Dominio.Restaurante;
import com.example.Restaurante.Restaurante.Infraestructura.Input.Rest.Model.Output.ResponseRestauranteDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/platillos")
public class PlatillosRestAdaptador {


    private final PlatillosRestMapper platillosRestMapper;
    private final CrearPlatilloInputPort crearPlatilloInputPort;

    private final ListarPlatillosInputPort listarPlatillosInputPort;
    private final ListarPlatilloEspecificoInputPort  listarPlatilloEspecificoInputPort;
    private final ListarPlatillosGlobalesInputPort listarPlatillosGlobalesInputPort;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponsePlatillosDTO> crearPlatillo(@RequestBody CrearPlatilloDTO crearPlatilloDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        this.platillosRestMapper.toResponsePlatillosDTO(
                                this.crearPlatilloInputPort.crearPlatillos(
                                        crearPlatilloDTO
                                )
                        )
                );

    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ResponsePlatillosDTO> listarPlatillosGloables() {
        return this.platillosRestMapper.toListPlatillosResponse(this.listarPlatillosGlobalesInputPort.listarPlatillosGlobales());
    }

    @GetMapping("/restaurante/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ResponsePlatillosDTO> listarPlatillos(@PathVariable UUID id) {
        return this.platillosRestMapper.toListPlatillosResponse(this.listarPlatillosInputPort.listarPlatillos(id));
    }


    @GetMapping("/{id}")
    public ResponsePlatillosDTO listarPlatilloEspecifico(@PathVariable UUID id) {
        Platillos platillos = this.listarPlatilloEspecificoInputPort
                .listarPlatillosEspecifico(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Restaurante no encontrado con id: " + id
                ));


        return this.platillosRestMapper.toResponsePlatillosDTO(platillos);

    }
}
