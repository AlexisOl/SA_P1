package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Service.GenerarGanancias;

import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Input.GanaciasHistoricasInputPort;
import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Input.GenerarGananciasInputPort;
import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output.GananciasHistorciasOutputPort;
import com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Ports.Output.GenerarGananciasOutputPort;
import com.example.facturacion.DetalleFactura_Hotel.Dominio.ObjetosDeValor.Ganancias;
import com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns.UsuariosFeing;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class CasoUsoGenerarGanancias implements GanaciasHistoricasInputPort {

    private final GenerarGananciasOutputPort generarGananciasOutputPort;
    private final UsuariosFeing usuariosFeing;


    public CasoUsoGenerarGanancias(GenerarGananciasOutputPort generarGananciasOutputPort,
                                   UsuariosFeing usuariosFeing){
        this.generarGananciasOutputPort = generarGananciasOutputPort;
        this.usuariosFeing=usuariosFeing;
    }
    @Override
    public List<Ganancias> gananciasHistoricas(Long id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //generacion de pagos
        List<Ganancias> elementos = new ArrayList<>();

        for (Object[] pagos: this.usuariosFeing.pagosEmpleado(id) ){
            String inicioStr = (String) pagos[4];
            String finStr = (String) pagos[5];

            LocalDate inicioLocal = LocalDate.parse(inicioStr, formatter);
            LocalDate finLocal = LocalDate.parse(finStr, formatter);

            Date inicio = java.sql.Date.valueOf(inicioLocal);
            Date fin = java.sql.Date.valueOf(finLocal);

            System.out.println(pagos[4]+"---"+pagos[5]);
            elementos.add(new Ganancias(
                    (Integer) pagos[0],
                    (Integer) pagos[1],
                    (Double) pagos[3],
                    inicio,
                    fin
            ));
        }

        // generacion de ganancias
        List<Ganancias> elementosGanancias = new ArrayList<>();
        for (Object[] pagos: this.generarGananciasOutputPort.gananciasHistoricas(id) ){
            elementosGanancias.add(new Ganancias(
                    (Integer) pagos[0],
                    (Integer) pagos[1],
                    (Double) pagos[2],
            (Date) pagos[3],
            (Date) pagos[4]
            ));
        }

        //union de manos

        Map<String, Ganancias> map = new HashMap<>();


        for (Ganancias pagos: elementos){
            String llave = pagos.getAnio()+ " - "+ pagos.getSemana();
            map.put(llave, pagos);
        }


        for (Ganancias ganancias: elementosGanancias){
            String llave = ganancias.getAnio()+ " - "+ ganancias.getSemana();
            map.merge(llave, ganancias, (existe, nuevo) -> {
                existe.setAcumulado(existe.getAcumulado()*-1 + nuevo.getAcumulado());
                return existe;
            });

        }

        List<Ganancias> listaFinal = new ArrayList<>(map.values());

        listaFinal.sort(Comparator
                .comparing(Ganancias::getAnio)
                .thenComparing(Ganancias::getSemana));

        for (Ganancias ganancias : listaFinal) {
            System.out.println(
                    ganancias.getAnio() + " - " +
                            ganancias.getSemana() + " - " +
                            ganancias.getAcumulado()
            );
        }

        return listaFinal;
    }
}
