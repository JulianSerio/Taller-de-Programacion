/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial31;

/**
 *
 * @author Julian
 */
public class Minorista extends Compra{
    private boolean jubilado;

    public Minorista(boolean jubilado, int numero, int DIMF) {
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
    public double precioAPagar(){
        double aux = super.precioAPagar();
        if (this.isJubilado()){
            double desc = (10 * super.precioAPagar()) / 100;
            aux = aux - desc;
        }
        return aux;
    }
    
    
    
    
}
