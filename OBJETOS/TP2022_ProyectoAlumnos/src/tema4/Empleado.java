/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Julian
 */
public abstract class Empleado {
    private String nombre;
    private double sueldo;
    private int antiguedad;

    public Empleado(String nombre, double sueldo, int antiguedad) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    public abstract double calcularEfectividad();
    public abstract double calcularSueldo();
    
    public double calcularSueldoACobrar(){
        double aux = (sueldo * 10) / 100; // saco 10% suponiendo que el sueldo es 100 el 10% es 10
        aux = sueldo + (aux * antiguedad); //100 + (10 * 40 (antiguedad))
        return aux + this.calcularSueldo(); // ademas sumo abstract
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", sueldo=" + this.calcularSueldoACobrar() + " efectividad=" + this.calcularEfectividad() + '}';
    }
}
