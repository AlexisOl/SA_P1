package com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Repository;

import com.example.Usuario.EmpleadoRestaurante.Dominio.EmpleadoRestaurante;
import com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Entity.EmpleadoRestauranteEntity;
import com.example.Usuario.Persona.Infraestructura.Adapters.Output.Persientece.Entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface EmpleadoRestauranteRepository extends JpaRepository<EmpleadoRestauranteEntity, UUID> {
    @Query("SELECT e FROM EmpleadoRestauranteEntity e where e.restauranteId= :restauranteId")
    List<EmpleadoRestauranteEntity> findAllByRestauranteId(UUID restauranteId);


    EmpleadoRestauranteEntity findByPersona_Cui(Long personaCui);

    @Query(
            value = """
    WITH RECURSIVE semanas AS (
        SELECT YEAR(MIN(eh.fecha)) AS anio, WEEK(MIN(eh.fecha)) AS semana
        FROM mcsv_usuario.empleado_restaurante eh
        WHERE eh.restaurante_id = :id
        UNION ALL
        SELECT
            CASE WHEN semana < 52 THEN anio ELSE anio + 1 END,
            CASE WHEN semana < 52 THEN semana + 1 ELSE 1 END
        FROM semanas
        WHERE (anio < YEAR(CURDATE()))
           OR (anio = YEAR(CURDATE()) AND semana < WEEK(CURDATE()))
    ),
    salarios AS (
        SELECT
            s.anio,
            s.semana,
            COALESCE(SUM(eh.salario / 4), 0) AS salario_semanal
        FROM semanas s
        LEFT JOIN mcsv_usuario.empleado_restaurante eh
            ON YEAR(eh.fecha) = s.anio
           AND WEEK(eh.fecha) = s.semana
           AND eh.restaurante_id = :id
        GROUP BY s.anio, s.semana
    )
    SELECT
        anio,
        semana,
        salario_semanal,
        @running_total := @running_total + salario_semanal AS acumulado,
        STR_TO_DATE(CONCAT(anio, semana, ' Monday'), '%X%V %W') AS inicio_semana,
          DATE_ADD(STR_TO_DATE(CONCAT(anio, semana, ' Monday'), '%X%V %W'), INTERVAL 6 DAY) AS fin_semana
    FROM salarios
    JOIN (SELECT @running_total := 0) AS vars
    ORDER BY anio, semana;
    """,
            nativeQuery = true
    )
    List<Object> estimarPerdidaPagosEmpleado(UUID id);

}
