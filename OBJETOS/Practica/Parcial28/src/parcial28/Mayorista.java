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
public class Mayorista extends Compra {
    private int cuil;

    public Mayorista(int cuil, int numero, int DIMF) {
        super(numero, DIMF);
        this.cuil = cuil;
    }

    public int getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    @Override
    public double precioAPagar() {
        double descuento;
        double aux = 0;
        for (int i = 0; i < this.getDimL(); i++){
            aux = aux + this.obtenerProd(i).getPrecioMayorista();
        }
        descuento = aux * 0.21;
        aux = aux - descuento;
        return aux;
    }

    @Override
    public String toString() {
        return super.toString() + " Cuil: " + cuil;
    }
    
    
    
    
    
}
