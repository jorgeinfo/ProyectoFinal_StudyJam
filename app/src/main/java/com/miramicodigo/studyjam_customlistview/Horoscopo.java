package com.miramicodigo.studyjam_customlistview;

import java.io.Serializable;



public class Horoscopo implements Serializable{
    private String Nombre;
    private String Horos;
    private String Tipo;

    private int Zodiac;

    private int Imagen;

    public Horoscopo() {
    }

    public Horoscopo(String nombre) {
        Nombre = nombre;
    }

    public Horoscopo(String nombre, String habilidades) {
        Nombre = nombre;
        Tipo = habilidades;
    }

    public Horoscopo(String nombre, String habilidades, String horos) {
        Nombre = nombre;
        Tipo = habilidades;
        Horos = horos;
    }

    public Horoscopo(String nombre, String habilidades,String horos, int zodiac) {
        Nombre = nombre;
        Tipo = habilidades;
        Horos = horos;
        Zodiac = zodiac;
    }
    public Horoscopo(String nombre, String habilidades,String horos, int zodiac, int imagen) {
        Nombre = nombre;
        Tipo = habilidades;
        Horos = horos;
        Zodiac = zodiac;
        Imagen = imagen;
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public String getHabilidades() {
        return Tipo;
    }

    public void setHabilidades(String habilidades) {
        Tipo = habilidades;
    }
    public String getHoros() {
        return Horos;
    }

    public void setHoros(String horos) {
        Horos = horos;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    public int getZodiac() {
        return Zodiac;
    }

    public void setZodiac(int zodiac) {
        Zodiac = zodiac;
    }
}
