/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial21;

/**
 *
 * @author Julian
 */
public class Persona {
    private String nombre;
    private int DNI;
    private double aporte;

    public Persona(String nombre, int DNI, double aporte) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.aporte = aporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public double getAporte() {
        return aporte;
    }

    public void setAporte(double aporte) {
        this.aporte = aporte;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", DNI=" + DNI + ", aporte=" + aporte + '}';
    }
    
    
    
}
