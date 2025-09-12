package com.example.facturacion.DetalleFactura_Hotel.Dominio.ObjetosDeValor;

public class Ganancias {
    private  int anio;
    private  int semana;
    private  double acumulado;

    public Ganancias(int anio, int semana, double acumulado) {
        this.anio = anio;
        this.semana = semana;
        this.acumulado = acumulado;
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
}
