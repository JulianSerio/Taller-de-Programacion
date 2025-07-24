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
public class Libro {
    private String titulo;
    private double precioBase;
    private int DIMF = 8;
    private int dimL = 0;
    private String []v = new String[DIMF];

    public Libro(String titulo, double precioBase) {
        this.titulo = titulo;
        this.precioBase = precioBase;
    }
    
    public void agregarAutor(String a){
        v[dimL] = a;
        dimL++;
    }
    
    public double precioFinal(){
        double aux = (21 * precioBase) / 100;
        return precioBase + aux;
    }

    public int getDIMF() {
        return DIMF;
    }

    public int getDimL() {
        return dimL;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    @Override
    public String toString() {
        return "Libro{" + "Titulo=" + titulo + " Precio Final=" + this.precioFinal() + " Nombre Primer Autor= " + v[0] + '}';
    }

    
    
    
    
}
