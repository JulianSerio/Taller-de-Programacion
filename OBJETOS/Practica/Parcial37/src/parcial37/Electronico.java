/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial37;

/**
 *
 * @author Julian
 */
public class Electronico extends Libro{
    private String formato;
    private double tamano;

    public Electronico(String formato, double tamano, String titulo, double precioBase) {
        super(titulo, precioBase);
        this.formato = formato;
        this.tamano = tamano;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }
    
    public double precioFinal(){
        double aux = 2.5 * this.getTamano();
        return aux + super.precioFinal();
    }
    
    
}
