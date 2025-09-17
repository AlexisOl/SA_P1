package com.example.Promociones.promocionesRestaurante.Aplicacion.Service.ListarPromociones;

import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.ListarPromocionesInputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.ListarPromocionesOutputPort;
import com.example.Promociones.PromocionesHotel.Dominio.PromocionesHotel;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.DTO.BuscarHabitacionResponseDTO;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.DTO.HotelDTO;
import com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.HoteleriaFeign;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Input.ListarPromocionesRestauranteInputPort;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Output.ListarPromocionesRestauranteOutputPort;
import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;
import com.example.Promociones.promocionesRestaurante.Infraestrucura.Feigns.DTO.BuscarPlatilloResponseDTO;
import com.example.Promociones.promocionesRestaurante.Infraestrucura.Feigns.DTO.RestauranteDTO;
import com.example.Promociones.promocionesRestaurante.Infraestrucura.Feigns.RestauranteFeign;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ListarPromocionesGeneralesRestaurante implements ListarPromocionesRestauranteInputPort {
    private final ListarPromocionesRestauranteOutputPort listarPromocionesOutputPort;
    private final RestauranteFeign restauranteFeign;

    public ListarPromocionesGeneralesRestaurante(ListarPromocionesRestauranteOutputPort listarPromocionesOutputPort,
                                             RestauranteFeign restauranteFeign){
        this.listarPromocionesOutputPort=listarPromocionesOutputPort;
        this.restauranteFeign=restauranteFeign;
    }


    @Override
    public List<PromocionRestaurante> listarPromocionesRestaurante(UUID id) {
        //ver si exisre le hotel
        RestauranteDTO obtieneRestaurante = this.restauranteFeign.listarRestauranteEspecifico(id).getBody();

        if(obtieneRestaurante == null){
            throw  new RuntimeException("No existe el restaurante");
        }
        List<BuscarPlatilloResponseDTO> platiilos = this.restauranteFeign.listarPlatillosRestaurante(id);

        if (platiilos == null || platiilos.isEmpty()) {
            throw new RuntimeException("El hotel no tiene habitaciones registradas");
        }

        List<UUID> idsRestaurante = platiilos.stream()
                .map(BuscarPlatilloResponseDTO::getId)
                .collect(Collectors.toList());

        return this.listarPromocionesOutputPort.listarPromocionesRestaurante(idsRestaurante);

    }
}
