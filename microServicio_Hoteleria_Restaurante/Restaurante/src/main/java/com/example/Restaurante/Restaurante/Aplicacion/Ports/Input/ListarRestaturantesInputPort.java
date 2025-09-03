package com.example.Restaurante.Restaurante.Aplicacion.Ports.Input;

import com.example.Restaurante.Restaurante.Dominio.Restaurante;

import java.util.List;
import java.util.UUID;

public interface ListarRestaturantesInputPort {

    List<Restaurante> listarRestaurantes();
}
