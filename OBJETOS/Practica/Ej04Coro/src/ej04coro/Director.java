/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej04coro;

/**
 *
 * @author Julian
 */
public class Director {
    private String nombre;
    private int DNI;
    private int antiguedad;
    private int edad;

    public Director(String nombre, int DNI, int antiguedad, int edad) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.antiguedad = antiguedad;
        this.edad = edad;
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

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Director{" + "nombre=" + nombre + ", DNI=" + DNI + ", antiguedad=" + antiguedad + '}';
    }
    
}
