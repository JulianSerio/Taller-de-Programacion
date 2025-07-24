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
public abstract class Compra {
    private int dimL = 0;
    private int DIMF;
    private int numero;
    private Producto []v;

    public Compra(int DIMF, int numero) {
        this.DIMF = DIMF;
        this.numero = numero;
        v = new Producto[DIMF];
        //se inicializan el vector en null
    }
    
    public void agregarProdcuto(Producto p){
        v[dimL] = p;
        dimL++;
    }
    
    public double precioAPagar(){
        double aux = 0;
        for (int i = 0; i < dimL; i++){
            aux = aux + v[i].getPrecio();
        }
        double iva = (21 * aux) / 100;
        return aux + iva;
    }

    public int getDimL() {
        return dimL;
    }

    public int getDIMF() {
        return DIMF;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        String aux = "Nro: " + numero + '\n';
         for (int i = 0; i < dimL; i++){
            aux = aux + v[i] + '\n';
        }
        return aux + " Precio Final: " + this.precioAPagar();
    }
    
    
    
    
    
    
     
    
}
