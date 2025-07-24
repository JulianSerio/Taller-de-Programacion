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
public class CompraMinorista extends Compra{
    private boolean jubilado;

    public CompraMinorista(boolean jubilado, int numero, int DIMF) {
        super(numero, DIMF);
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
        return "CompraMinorista: " + super.toString() + " Precio a pagar: " + this.precioAPagar() + " Es jubilado: " + jubilado;
    }
   
    
}
