/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial44;

/**
 *
 * @author Julian
 */
public class Paciente {
    private String nombre;
    private double costo;
    private boolean obraSocial;

    public Paciente(String nombre, double costo, boolean obraSocial) {
        this.nombre = nombre;
        this.costo = costo;
        this.obraSocial = obraSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(boolean obraSocial) {
        this.obraSocial = obraSocial;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nombre=" + nombre + ", costo=" + costo + ", obraSocial=" + obraSocial + '}';
    }
    
    
    
}
