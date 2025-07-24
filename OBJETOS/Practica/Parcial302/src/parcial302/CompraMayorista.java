/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial302;

/**
 *
 * @author Julian
 */
public class CompraMayorista extends Compra {
    private int CUIT;

    public CompraMayorista(int CUIT, int numero, int DIMF) {
        super(numero, DIMF);
        this.CUIT = CUIT;
    }

    public int getCUIT() {
        return CUIT;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }

    @Override
    public String toString() {
        double aux = this.precioAPagar() * 0.21; 
        aux = this.precioAPagar() - aux;
        return "CompraMayorista: " + super.toString() + " Precio a pagar: " + aux + " CUIT: " + CUIT;
    }
}
