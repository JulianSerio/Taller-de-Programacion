/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial29;

/**
 *
 * @author Julian
 */
public class Mayorista extends Compra {
    private int cuit;

    public Mayorista(int cuit, int DIMF, int numero) {
        super(DIMF, numero);
        this.cuit = cuit;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    @Override
    public String toString() {
        return "Compra Mayorista: " + super.toString() + " Cuit: " + cuit;
    }
    
    
    
}
