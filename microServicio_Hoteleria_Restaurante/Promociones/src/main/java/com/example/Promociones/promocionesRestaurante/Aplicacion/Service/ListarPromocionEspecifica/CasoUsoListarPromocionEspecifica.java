package com.example.Promociones.promocionesRestaurante.Aplicacion.Service.ListarPromocionEspecifica;

import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Input.ListarPromocionEspecificaInputPort;
import com.example.Promociones.PromocionesHotel.Aplicacion.Ports.Output.ListarPromocionEspecificaOutputPort;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Input.ListarPromocionesEspecificasRestauranteInputPort;
import com.example.Promociones.promocionesRestaurante.Aplicacion.Ports.Output.ListarPromocionesEspecificasRestauranteOutputPort;
import com.example.Promociones.promocionesRestaurante.Dominio.PromocionRestaurante;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service

public class CasoUsoListarPromocionEspecifica implements ListarPromocionesEspecificasRestauranteInputPort {
    private final ListarPromocionesEspecificasRestauranteOutputPort listarPromocionesEspecificasRestauranteOutputPort;

    public CasoUsoListarPromocionEspecifica(ListarPromocionesEspecificasRestauranteOutputPort listarPromocionesEspecificasRestauranteOutputPort){
        this.listarPromocionesEspecificasRestauranteOutputPort=listarPromocionesEspecificasRestauranteOutputPort;

    }

    @Override
    public PromocionRestaurante ListarPromocionEspecificaRestaurante(UUID id) {
        return this.listarPromocionesEspecificasRestauranteOutputPort.ListarPromocionEspecificaRestaurante(id);
    }
}
