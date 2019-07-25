package edu.tallerjava.controladores;

public class Saludo {
    private String nombre;
    private String saludo;

    public Saludo(String nombre, String saludo){
        this.nombre = nombre;
        this.saludo = saludo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }
}
