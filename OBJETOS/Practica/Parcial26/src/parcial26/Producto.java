/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial26;

/**
 *
 * @author Julian
 */
public class Producto {
    private int codigo;
    private double precioMayorista;
    private double precioMinorista;

    public Producto(int codigo, double precioMayorista, double precioMinorista) {
        this.codigo = codigo;
        this.precioMayorista = precioMayorista;
        this.precioMinorista = precioMinorista;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecioMayorista() {
        return precioMayorista;
    }

    public void setPrecioMayorista(double precioMayorista) {
        this.precioMayorista = precioMayorista;
    }

    public double getPrecioMinorista() {
        return precioMinorista;
    }

    public void setPrecioMinorista(double precioMinorista) {
        this.precioMinorista = precioMinorista;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo;
    }
    
    
}
