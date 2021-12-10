package com.example.examen.models.entity;

public class Ubication2 {
    String  fecha_registro;
    String  latitud;
    String  longitud;

    Ubication2(){}

    public Ubication2(String fecha_registro, String latitud, String longitud) {
        this.fecha_registro = fecha_registro;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Ubication2{" +
                "fecha_registro='" + fecha_registro + '\'' +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                '}';
    }
}


