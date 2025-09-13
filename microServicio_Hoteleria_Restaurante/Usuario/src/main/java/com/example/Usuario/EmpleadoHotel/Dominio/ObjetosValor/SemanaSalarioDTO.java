package com.example.Usuario.EmpleadoHotel.Dominio.ObjetosValor;

public class SemanaSalarioDTO {

    private final int anio;
    private final int semana;
    private final double salarioSemanal;
    private final double acumulado;

    public SemanaSalarioDTO(int anio, int semana, double salarioSemanal, double acumulado) {
        this.anio = anio;
        this.semana = semana;
        this.salarioSemanal = salarioSemanal;
        this.acumulado = acumulado;
    }

    public int getAnio() {
        return anio;
    }

    public int getSemana() {
        return semana;
    }

    public double getSalarioSemanal() {
        return salarioSemanal;
    }

    public double getAcumulado() {
        return acumulado;
    }
}
