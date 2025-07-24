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
public class Mayorista extends Compra{
    private int cuil;

    public Mayorista(int cuil, int numero, int DIMF) {
        super(numero, DIMF);
        this.cuil = cuil;
    }
    
    public double precioAPagar(){
        double iva = (21 * super.precioAPagar()) / 100;
        return super.precioAPagar() - iva;
    }

    public int getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }
    
}
