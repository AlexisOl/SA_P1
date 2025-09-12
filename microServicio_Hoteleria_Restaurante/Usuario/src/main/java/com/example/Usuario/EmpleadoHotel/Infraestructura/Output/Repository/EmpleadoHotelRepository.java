package com.example.Usuario.EmpleadoHotel.Infraestructura.Output.Repository;

import com.example.Usuario.EmpleadoHotel.Infraestructura.Output.Entity.EmpleadoHotelEntity;
import com.example.Usuario.EmpleadoRestaurante.Infraestructura.Output.Entity.EmpleadoRestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public interface EmpleadoHotelRepository extends JpaRepository<EmpleadoHotelEntity,Integer> {
    EmpleadoHotelEntity findById(UUID id);

    List<EmpleadoHotelEntity> findAllByIdhotel(Long idhotel);

    EmpleadoHotelEntity findByPersona_Cui(Long personaCui);


    @Query(
            value = """
    WITH RECURSIVE semanas AS (
        SELECT YEAR(MIN(eh.fecha)) AS anio, WEEK(MIN(eh.fecha)) AS semana
        FROM mcsv_usuario.empleado_hotel eh
        WHERE eh.idhotel = :id
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
        LEFT JOIN mcsv_usuario.empleado_hotel eh
            ON YEAR(eh.fecha) = s.anio
           AND WEEK(eh.fecha) = s.semana
           AND eh.idhotel = :id
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
    List<Object> estimarPerdidaPagosEmpleado(Long id);



    @Query(
            value = """
    WITH RECURSIVE semanas AS (
        SELECT YEAR(MIN(eh.fecha)) AS anio, WEEK(MIN(eh.fecha)) AS semana
        FROM mcsv_usuario.empleado_hotel eh
        WHERE eh.id = :id
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
        LEFT JOIN mcsv_usuario.empleado_hotel eh
            ON YEAR(eh.fecha) = s.anio
           AND WEEK(eh.fecha) = s.semana
           AND eh.id = :id
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
    List<Object> estimarPagosEmpleadoEspecifico(UUID id);


}
