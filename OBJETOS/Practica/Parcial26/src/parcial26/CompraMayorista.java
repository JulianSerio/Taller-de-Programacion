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
public class CompraMayorista extends Compra {
    private int cuit;

    public CompraMayorista(int cuit, int numero, int DIMF) {
        super(numero, DIMF);
        this.cuit = cuit;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    @Override
    public double precioAPagar(int I) {
        double aux = (21 * this.getPosicion(I).getPrecioMayorista()) / 100;
        return aux = this.getPosicion(I).getPrecioMayorista() - aux;
    }
 
}
