package com.example.hoteleria.Rerservacion.Aplicacion.Service.CasosUso.ListarReservacionEspecifica;

import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Input.ListarReservacionEspecificaInput;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Input.ListarReservacionesUsuarioInputPort;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.ListarReservacionEspecificaOutput;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.ListarReservacionesUsuarioOutputPort;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class ListarReservacionEspecificaID implements ListarReservacionEspecificaInput {

    private final ListarReservacionEspecificaOutput listarReservacionEspecificaOutput;


    public ListarReservacionEspecificaID(ListarReservacionEspecificaOutput listarReservacionEspecificaOutput) {
        this.listarReservacionEspecificaOutput = listarReservacionEspecificaOutput;
    }

    @Override
    public Reservacion ListarReservacionEspecifica(UUID id) {
        return this.listarReservacionEspecificaOutput.ListarReservacionEspecifica(id);
    }
}
