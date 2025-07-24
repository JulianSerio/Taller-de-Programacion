/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial26;

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
    }
    
    public void agregarProducto(Producto p){
        v[dimL] = p;
        dimL++;
    }
    
    public abstract double precioAPagar(int I);

    public int getDimL() {
        return dimL;
    }

    public Producto getPosicion(int i) {
        return v[i];
    }

    public double totalPagado(){
        double aux = 0;
        for (int i = 0; i < dimL; i++){
            aux = aux + this.precioAPagar(i);
        }
        return aux;
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
        String aux = "Nro: " + numero + " Productos comprados: " + '\n';
        for (int i = 0; i < dimL; i++){
            aux = aux + v[i] + " Precio pagado: " + this.precioAPagar(i) + '\n';
        }
        return aux + " Total pagado: " + this.totalPagado();
    }
    
    
    
    
}
