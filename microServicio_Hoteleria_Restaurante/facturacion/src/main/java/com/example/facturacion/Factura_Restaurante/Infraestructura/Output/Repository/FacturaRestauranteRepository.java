package com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Repository;

import com.example.facturacion.Factura_Restaurante.Infraestructura.Output.Entity.FacturaRestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface FacturaRestauranteRepository  extends JpaRepository<FacturaRestauranteEntity, UUID> {
    @Query("SELECT f from FacturaRestauranteEntity f where f.id_Cliente =:idUsuario")
    List<FacturaRestauranteEntity> findAllByCliente(UUID idUsuario);


    @Query(value ="""
            WITH RECURSIVE semanas AS (
              SELECT YEAR(MIN(df.fecha)) AS anio, WEEK(MIN(df.fecha)) AS semana
              FROM facturacion_mcsv.factura_restaurante df
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
             	sum(COALESCE(df.precio, 0)) as salario_semanal
              FROM semanas s
              LEFT JOIN facturacion_mcsv.factura_restaurante df
                ON YEAR(df.fecha) = s.anio AND WEEK(df.fecha) = s.semana
              GROUP BY s.anio, s.semana
            )
            SELECT
              anio,
              semana,
              salario_semanal,
              STR_TO_DATE(CONCAT(anio, semana, ' Monday'), '%X%V %W') AS inicio_semana,
             DATE_ADD(STR_TO_DATE(CONCAT(anio, semana, ' Monday'), '%X%V %W'), INTERVAL 6 DAY) AS fin_semana
            FROM salarios
            ORDER BY anio, semana;
        """,
            nativeQuery = true
    )
    List<Object[]> gananciasHistoricas(Long id);
}
