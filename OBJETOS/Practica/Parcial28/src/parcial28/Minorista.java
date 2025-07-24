/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial28;

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
    public double precioAPagar() {
        double descuento;
        double aux = 0;
        for (int i = 0; i < this.getDimL(); i++){
            aux = aux + this.obtenerProd(i).getPrecioMinorista();
        }
        if (this.isJubilado()){
            descuento = aux * 0.1;
            aux = aux - descuento;
        }
        return aux;
    }

    @Override
    public String toString() {
        return super.toString() + " Jubilado: " + jubilado;
    }
    
    
    
}
