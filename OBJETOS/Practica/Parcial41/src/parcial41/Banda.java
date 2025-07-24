/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial41;

/**
 *
 * @author Julian
 */
public class Banda {
    private String nombre;
    private String ciudad;
    private int miembros;

    public Banda(String nombre, String ciudad, int miembros) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.miembros = miembros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getMiembros() {
        return miembros;
    }

    public void setMiembros(int miembros) {
        this.miembros = miembros;
    }

    @Override
    public String toString() {
        return "Banda{" + "nombre=" + nombre + ", ciudad=" + ciudad + ", miembros=" + miembros + '}';
    }
    
    
    
    
}
