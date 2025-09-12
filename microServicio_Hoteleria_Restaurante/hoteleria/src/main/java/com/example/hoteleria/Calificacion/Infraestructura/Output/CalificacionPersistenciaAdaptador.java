package com.example.hoteleria.Calificacion.Infraestructura.Output;

import com.example.hoteleria.Calificacion.Aplicacion.Ports.Output.CrearCalificacionOutputPort;
import com.example.hoteleria.Calificacion.Aplicacion.Ports.Output.ListarCalificacionesOutputPort;
import com.example.hoteleria.Calificacion.Aplicacion.Ports.Output.ObtenerHabitacionConMejorPuntuacionOutputPort;
import com.example.hoteleria.Calificacion.Aplicacion.Ports.Output.PromedioValoracionHabitacion;
import com.example.hoteleria.Calificacion.Dominio.Calificacion;
import com.example.hoteleria.Calificacion.Infraestructura.Output.Entity.CalificacionEntity;
import com.example.hoteleria.Calificacion.Infraestructura.Output.Mapper.CalificacionMapper;
import com.example.hoteleria.Calificacion.Infraestructura.Output.Repository.CalificacionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class CalificacionPersistenciaAdaptador implements CrearCalificacionOutputPort, PromedioValoracionHabitacion, ListarCalificacionesOutputPort,
        ObtenerHabitacionConMejorPuntuacionOutputPort {


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

    @Override
    public Double promedioValoracion(UUID id) {
        return this.calificacionRepository.calcularPromedioValoracionHabitacion(id);
    }

    @Override
    public List<Calificacion> listarCalificacionesPorHabitacion(UUID id) {

        List<CalificacionEntity> entidades = this.calificacionRepository.findAllByReservacion_Habitacion_Id(id);
        System.out.println("Entidades encontradas: " + entidades);

        List<Calificacion> dominio = this.calificacionMapper.toCalificacionList(entidades);
        System.out.println("Después del mapper: " + dominio);

        System.out.println(this.calificacionRepository.findAllByReservacion_Habitacion_Id(id));
        return this.calificacionMapper.toCalificacionList(
                this.calificacionRepository.findAllByReservacion_Habitacion_Id(id)
        );
    }

    @Override
    public UUID obtenerHabitacionConMejorPuntuacion() {
        return this.calificacionRepository.findHabitacionMejorPuntuada();
    }
}
