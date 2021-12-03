
package com.emergentes.modelo;

public class Producto 
{
  private int id;
    private String nombre;
    private String descripcion;
    private int entrada_inicial;
    private int stock; 
    private int precio;

    public Producto()
    {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEntrada_inicial() {
        return entrada_inicial;
    }

    public void setEntrada_inicial(int entrada_inicial) {
        this.entrada_inicial = entrada_inicial;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", entrada_inicial=" + entrada_inicial + ", stock=" + stock + ", precio=" + precio + '}';
    }

    

  

    
    
}
