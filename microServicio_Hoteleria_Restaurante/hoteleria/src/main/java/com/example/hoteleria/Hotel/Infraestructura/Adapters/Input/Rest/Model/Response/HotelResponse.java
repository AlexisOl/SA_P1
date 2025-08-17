package com.example.hoteleria.Hotel.Infraestructura.Adapters.Input.Rest.Model.Response;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelResponse {

    private Long id;

    private String nombre;

    private String direccion;

    private Long telefono;
}
