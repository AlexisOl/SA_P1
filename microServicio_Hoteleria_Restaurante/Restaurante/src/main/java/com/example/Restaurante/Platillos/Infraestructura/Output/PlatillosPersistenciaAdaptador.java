package com.example.Restaurante.Platillos.Infraestructura.Output;


import com.example.Restaurante.Platillos.Aplicacion.Ports.Output.CrearPlatilloOutputPort;
import com.example.Restaurante.Platillos.Aplicacion.Ports.Output.ListarPlatilloEspecificoOutputPort;
import com.example.Restaurante.Platillos.Aplicacion.Ports.Output.ListarPlatillosOutputPort;
import com.example.Restaurante.Platillos.Dominio.Platillos;
import com.example.Restaurante.Platillos.Infraestructura.Output.Mapper.PlatillosMapper;
import com.example.Restaurante.Platillos.Infraestructura.Output.Repository.PlatillosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor

public class PlatillosPersistenciaAdaptador implements CrearPlatilloOutputPort, ListarPlatilloEspecificoOutputPort ,
        ListarPlatillosOutputPort {
    private PlatillosMapper platillosMapper;
    private PlatillosRepository platillosRepository;


    @Override
    public Platillos crearPlatillos(Platillos platillos) {
        return this.platillosMapper.toPlatillos(
                this.platillosRepository.save(
                        this.platillosMapper.toPlatillosEntity(platillos)
                )
        );
    }

    @Override
    public Platillos listarPlatillosEspecificos(UUID id) {
        return
                this.platillosMapper.toPlatillos(
                        this.platillosRepository.findById(id).get()
        );
    }

    @Override
    public List<Platillos> listarPlatillos(UUID id) {

        System.out.println(this.platillosRepository.buscarPlatillosPorRestaurante(id));
        return (this.platillosMapper.toListPlatillos(
                this.platillosRepository.buscarPlatillosPorRestaurante(id)
        ));
    }
}
