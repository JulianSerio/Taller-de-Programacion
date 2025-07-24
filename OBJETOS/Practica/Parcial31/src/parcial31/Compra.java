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
public abstract class Compra {
    private int numero;
    private int dimL = 0;
    private int DIMF;
    private Producto []v;

    public Compra(int numero, int DIMF) {
        this.numero = numero;
        this.DIMF = DIMF;
        v = new Producto[DIMF];
        //iniciliazo vector en null
    }
    
    public void agregarProducto (Producto p){
        v[dimL] = p;
        dimL++;
    }
    
    public double precioAPagar(){
        double aux = 0;
        for (int i = 0; i < dimL; i++){
            aux = aux + v[i].getPrecio();
        }
        return aux;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDimL() {
        return dimL;
    }

    public int getDIMF() {
        return DIMF;
    }

    @Override
    public String toString() {
        String aux = "Nro: " + numero + '\n';
        for (int i = 0; i < dimL; i++){
            aux = aux + v[i] + '\n';
        }
        return aux + "Precio a pagar: " + this.precioAPagar();
    }
    
    
    
    
    
    
}
