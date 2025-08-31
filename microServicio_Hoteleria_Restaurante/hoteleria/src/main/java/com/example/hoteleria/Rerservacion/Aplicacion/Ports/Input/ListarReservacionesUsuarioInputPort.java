package com.example.hoteleria.Rerservacion.Aplicacion.Ports.Input;

import com.example.hoteleria.Rerservacion.Dominio.Reservacion;

import java.util.List;
import java.util.UUID;

public interface ListarReservacionesUsuarioInputPort {

    List<Reservacion> listarReservacionesUsuario(UUID id_usuario);
}
