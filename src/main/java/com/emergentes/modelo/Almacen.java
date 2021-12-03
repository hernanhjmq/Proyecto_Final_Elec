package com.emergentes.modelo;

public class Almacen 
{
     private int id;
     private String descaripcion;
     private String coordenadas;
     private int id_producto;
     
     private String nombrepro;
     private String descripro;

    public Almacen() 
    {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescaripcion() {
        return descaripcion;
    }

    public void setDescaripcion(String descaripcion) {
        this.descaripcion = descaripcion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public String getDescripro() {
        return descripro;
    }

    public void setDescripro(String descripro) {
        this.descripro = descripro;
    }

    
    
    @Override
    public String toString() {
        return "Almacen{" + "id=" + id + ", descaripcion=" + descaripcion + ", coordenadas=" + coordenadas + ", id_producto=" + id_producto + '}';
    }

    
  
    
     
}
