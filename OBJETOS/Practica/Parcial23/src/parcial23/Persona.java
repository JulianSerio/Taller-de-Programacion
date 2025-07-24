/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial23;

/**
 *
 * @author Julian
 */
public class Persona {
    private String nombre;
    private int dni;
    private double colaboracion;

    public Persona(String nombre, int dni, double colaboracion) {
        this.nombre = nombre;
        this.dni = dni;
        this.colaboracion = colaboracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getColaboracion() {
        return colaboracion;
    }

    public void setColaboracion(double colaboracion) {
        this.colaboracion = colaboracion;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", dni=" + dni;
    }
    
    
    
}
