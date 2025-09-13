package com.example.facturacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient

@EnableFeignClients(basePackages = {"com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns",
        "com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Feigns",
        "com.example.facturacion.Factura_Restaurante.Infraestructura.Feigns"})
@SpringBootApplication
public class FacturacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturacionApplication.class, args);
	}

}
