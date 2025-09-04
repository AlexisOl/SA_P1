package com.example.hoteleria.Calificacion.Infraestructura.Output;

import com.example.hoteleria.Calificacion.Aplicacion.Ports.Output.CrearCalificacionOutputPort;
import com.example.hoteleria.Calificacion.Dominio.Calificacion;
import com.example.hoteleria.Calificacion.Infraestructura.Output.Mapper.CalificacionMapper;
import com.example.hoteleria.Calificacion.Infraestructura.Output.Repository.CalificacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CalificacionPersistenciaAdaptador implements CrearCalificacionOutputPort {


    private final CalificacionRepository calificacionRepository;
    private final CalificacionMapper calificacionMapper;


    @Override
    public Calificacion crearCalificacion(Calificacion calificacion) {
        return this.calificacionMapper.toCalificacion(
                this.calificacionRepository.save(
                        this.calificacionMapper.toCalificacionEntity(calificacion)
                )
        );
    }
}
