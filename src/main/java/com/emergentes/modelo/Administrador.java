
package com.emergentes.modelo;

public class Administrador 
{
    private int id;
    private String privilegio;
    private String contraseña;
    private String correo;

    public Administrador() 
    {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Administrador{" + "id=" + id + ", privilegio=" + privilegio + ", contrase\u00f1a=" + contraseña + ", correo=" + correo + '}';
    }
    
   
    
    
}
