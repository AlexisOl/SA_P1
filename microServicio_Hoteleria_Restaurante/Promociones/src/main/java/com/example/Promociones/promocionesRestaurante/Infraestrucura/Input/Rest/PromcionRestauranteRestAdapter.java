package com.example.Promociones.promocionesRestaurante.Infraestrucura.Input.Rest;

import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.CrearPromocionHotelInputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.LIstarPromocionesActualesHotelInputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.ListarPromocionEspecificaInputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.ListarPromocionesInputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Service.CrearPromocionHotel.CrearPromocionDTO;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Input.Rest.MapperRest.PromocionHotelRestMapper;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Input.Rest.Model.Response.ResponsePromocionHotelDTO;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Input.CrearPromocionRestauranteInputPort;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Input.LIstarPromocionActualesRestauranteInputPort;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Input.ListarPromocionesEspecificasRestauranteInputPort;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Input.ListarPromocionesRestauranteInputPort;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Output.ListarPromocionesRestauranteActualesOutputPort;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Service.CasoUsoCrearPromocion.CrearPromocionRestauranteDTO;
import com.example.Promociones.promocionesRestaurante.Infraestrucura.Input.Rest.MapperRest.PromocionRestauranteRestMapper;
import com.example.Promociones.promocionesRestaurante.Infraestrucura.Input.Rest.Model.Response.ResponsePromcionRestauranteDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/promocionRestaurante")
public class PromcionRestauranteRestAdapter {
    private final CrearPromocionRestauranteInputPort crearPromocionRestauranteInputPort;
    private final PromocionRestauranteRestMapper promocionRestauranteRestMapper;
    private final ListarPromocionesRestauranteInputPort listarPromocionesRestauranteInputPort;
    private final LIstarPromocionActualesRestauranteInputPort lIstarPromocionActualesRestauranteInputPort;
    private final ListarPromocionesEspecificasRestauranteInputPort listarPromocionesEspecificasRestauranteInputPort;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponsePromcionRestauranteDTO> crearPromocion(@Valid @RequestBody CrearPromocionRestauranteDTO crearPromocionRestauranteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.promocionRestauranteRestMapper.toResponsePromcionRestauranteDto(
                        crearPromocionRestauranteInputPort.crearPromocion((crearPromocionRestauranteDTO))
                ));
    }

    @GetMapping("/restaurante/{id}")
    public List<ResponsePromcionRestauranteDTO> obtenerPromocionesPorRestaurante(@PathVariable UUID id ) {
        return this.promocionRestauranteRestMapper.toResponsePromcionRestauranteDtos(
                listarPromocionesRestauranteInputPort.listarPromocionesRestaurante(id)

        );
    }


    //por platillo actual
    @GetMapping("/actualEspecifica/{id}")
    public ResponsePromcionRestauranteDTO onbtenerPromocionActual(@Valid @PathVariable UUID id) {
        return this.promocionRestauranteRestMapper.toResponsePromcionRestauranteDto(
                lIstarPromocionActualesRestauranteInputPort.ListarPromocionActual(id)
        );
    }
    // especifico de promcion
    @GetMapping("/{id}")
    public ResponsePromcionRestauranteDTO onbtenerPromocionEspecifica(@Valid @PathVariable UUID id) {
        return this.promocionRestauranteRestMapper.toResponsePromcionRestauranteDto(
                listarPromocionesEspecificasRestauranteInputPort.ListarPromocionEspecificaRestaurante(id)

        );
    }
}
