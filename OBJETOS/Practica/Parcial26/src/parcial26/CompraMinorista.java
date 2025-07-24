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
    public double precioAPagar(int I) {
        double aux = 0;
        if (this.isJubilado()){
            aux = (10 * this.getPosicion(I).getPrecioMinorista()) / 100;
        }
        return aux = this.getPosicion(I).getPrecioMinorista() - aux;
    }
    
    
    
}
