package com.juanjiga.multicronoa;

public class Reloj {
    private int minutos;
    private int segundos;
    private int segundosTotales;
    private double porcentaje;
    private boolean onoff;
    private String color;
    private String colorNumero;
    private int segundosHoy;

    Reloj (){
        minutos = 0;
        segundos = 0;
        segundosTotales = 0;
        porcentaje = 0;
        onoff = false;
        color = "RED";
        colorNumero = "WHITE";
    }
    public void setSegundos(int segundos){
        this.segundos = segundos;
    }
    public void setMinutos(int minutos){
        this.minutos=minutos;
    }
    public int getMinutos(){
        return minutos;
    }
    public int getSegundos(){
        return segundos;
    }
    public int getSegundosTotales(){return segundosTotales;}
    public void sumaSegundos(){
        segundosTotales++;
        segundos++;
        if (segundos == 60){
            segundos = 0;
            minutos ++;
            if (minutos == 99){
                minutos = 0;
            }
        }
    }
    public boolean getOnOff(){
        return onoff;
    }
    public void setOff(){
        this.onoff = false;
        this.color = "RED";
        this.colorNumero = "WHITE";
    }
    public void setOn(){
        this.onoff = true;
        this.color = "GREEN";
        this.colorNumero = "BLACK";
    }
    public String getColor(){
        return color;
    }
    public String getColorNumero(){
        return colorNumero;
    }
    public void setPorcentaje(double porcentaje){
        this.porcentaje = porcentaje;
    }
    public int getPorcentajEntero(){
        return (int)porcentaje;
    }
}

