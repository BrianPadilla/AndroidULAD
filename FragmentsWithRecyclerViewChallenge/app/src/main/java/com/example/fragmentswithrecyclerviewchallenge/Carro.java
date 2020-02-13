package com.example.fragmentswithrecyclerviewchallenge;



public class Carro {

    String modelo,dueño,telefono;
    Integer imagen;


    public Carro(String dueño, String modelo, String telefono, Integer imagen) {
        this.modelo = modelo;
        this.dueño = dueño;
        this.telefono = telefono;
        this.imagen = imagen;

    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }
}
