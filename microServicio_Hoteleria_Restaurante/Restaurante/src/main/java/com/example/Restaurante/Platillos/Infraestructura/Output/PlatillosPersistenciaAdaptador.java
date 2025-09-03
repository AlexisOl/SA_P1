package com.example.Restaurante.Platillos.Infraestructura.Output;


import com.example.Restaurante.Platillos.Aplicacion.Ports.Output.CrearPlatilloOutputPort;
import com.example.Restaurante.Platillos.Dominio.Platillos;
import com.example.Restaurante.Platillos.Infraestructura.Output.Mapper.PlatillosMapper;
import com.example.Restaurante.Platillos.Infraestructura.Output.Repository.PlatillosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor

public class PlatillosPersistenciaAdaptador implements CrearPlatilloOutputPort {
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
}
