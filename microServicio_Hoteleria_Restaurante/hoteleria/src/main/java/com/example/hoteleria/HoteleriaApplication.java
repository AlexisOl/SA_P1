package com.example.hoteleria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.example.hoteleria.Habitaciones", "com.example.hoteleria.Hotel"})
public class HoteleriaApplication {

	public static void main(String[] args) {

		SpringApplication.run(HoteleriaApplication.class, args);
	}

}
