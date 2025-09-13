package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.DTO;

import java.util.Date;

public class Ganancias {
    private  int anio;
    private  int semana;
    private  double acumulado;
    private Date inicio_semana;
    private Date fin_semana;

    public Ganancias(int anio, int semana, double acumulado, Date inicio_semana, Date fin_semana) {
        this.anio = anio;
        this.semana = semana;
        this.acumulado = acumulado;
        this.inicio_semana = inicio_semana;
        this.fin_semana = fin_semana;
    }

    public int getAnio() {
        return anio;
    }

    public int getSemana() {
        return semana;
    }


    public double getAcumulado() {
        return acumulado;
    }



    public void setAcumulado(double acumulado) {
        this.acumulado = acumulado;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public void setInicio_semana(Date inicio_semana) {
        this.inicio_semana = inicio_semana;
    }
    public void setFin_semana(Date fin_semana) {
        this.fin_semana = fin_semana;
    }

    public Date getInicio_semana() {
        return inicio_semana;
    }

    public Date getFin_semana() {
        return fin_semana;
    }
}
