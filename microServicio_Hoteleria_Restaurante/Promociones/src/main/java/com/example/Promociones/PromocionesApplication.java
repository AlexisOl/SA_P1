package com.example.Promociones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns",
        "com.example.Promociones.promocionesRestaurante.Infraestrucura.Feigns"})

@SpringBootApplication
@EnableDiscoveryClient

public class PromocionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromocionesApplication.class, args);
	}

}
