/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Adicionales;

/**
 *
 * @author Julian
 */
public class Habitacion {
    private double costo;
    private boolean ocupada = false;
    private Persona cliente;

    public Habitacion(boolean ocupada, Persona cliente) {
        this.ocupada = ocupada;
        this.cliente = cliente;
    }

    public Habitacion(double costo) {
        this.costo = costo;
    }
    
    public void aumentoPrecio (double aumento){
        this.costo = this.costo + aumento;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        if (this.isOcupada()){
            return "Habitacion{" + "costo=" + costo + ", ocupada=" + ocupada + ", cliente=" + cliente + '}';
        }
        else{
            return "Habitacion{" + "costo=" + costo + ", libre" + '}';
        }
    }
    
    
    
    
}
