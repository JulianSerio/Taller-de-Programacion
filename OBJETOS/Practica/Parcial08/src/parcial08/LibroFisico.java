/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial08;

/**
 *
 * @author Julian
 */
public class LibroFisico extends Libro{
    private boolean tapaDura;

    public LibroFisico(boolean tapaDura, String titulo, double precioBase) {
        super(titulo, precioBase);
        this.tapaDura = tapaDura;
    }

    public boolean isTapaDura() {
        return tapaDura;
    }

    public void setTapaDura(boolean tapaDura) {
        this.tapaDura = tapaDura;
    }

    @Override
    public String toString() {
        return "Libro fisico: " + super.toString() + " Tapa dura: " + tapaDura;
    }
    
    
    
    
}
