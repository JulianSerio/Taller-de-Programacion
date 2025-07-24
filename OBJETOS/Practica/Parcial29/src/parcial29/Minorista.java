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
public class Minorista extends Compra{
    private boolean jubilado;

    public Minorista(boolean jubilado, int DIMF, int numero) {
        super(DIMF, numero);
        this.jubilado = jubilado;
    }

    public boolean isJubilado() {
        return jubilado;
    }

    public void setJubilado(boolean jubilado) {
        this.jubilado = jubilado;
    }

    @Override
    public String toString() {
        return "Compra Minorista: " + super.toString() + " Jubilado: " + jubilado;
    }
    
    
    
}
