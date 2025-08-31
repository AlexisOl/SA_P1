package com.example.hoteleria.Rerservacion.Aplicacion.Service.CasosUso.ListarReservacionesUsuario;

import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Input.ListarReservacionesUsuarioInputPort;
import com.example.hoteleria.Rerservacion.Aplicacion.Ports.Output.ListarReservacionesUsuarioOutputPort;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ListarReservaciones implements ListarReservacionesUsuarioInputPort {

    private final ListarReservacionesUsuarioOutputPort listarReservacionesUsuarioOutputPort;

    public ListarReservaciones (ListarReservacionesUsuarioOutputPort listarReservacionesUsuarioOutputPort) {
        this.listarReservacionesUsuarioOutputPort = listarReservacionesUsuarioOutputPort;
    }


    @Override
    public List<Reservacion> listarReservacionesUsuario(UUID id_usuario) {
        return this.listarReservacionesUsuarioOutputPort.listarReservacionesUsuario(id_usuario);
    }
}
