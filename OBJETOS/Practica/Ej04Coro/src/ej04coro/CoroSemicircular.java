/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej04coro;

/**
 *
 * @author Julian
 */
public class CoroSemicircular extends Coro {
    private int DIMF;
    private int dimL = 0;
    private Corista [] v;

    public CoroSemicircular(int DIMF, String nombre, Director director) {
        super(nombre, director);
        this.DIMF = DIMF;
        v = new Corista[DIMF];
    }
    
    @Override
    public void agregarCorista(Corista c) {
        if (dimL < DIMF){
            v[dimL] = c;
            dimL++;
        }
    }

    @Override
    public boolean estaLleno() {
        boolean lleno = false;
        if (dimL == DIMF){
            lleno = true;
        }
        return lleno;
    }


    public int getDIMF() {
        return DIMF;
    }

    @Override
    public String toString() {
        String aux = super.toString();
        for (int i = 0; i < dimL; i++){
            aux = aux + v[i].toString() + '\n';
        }
        return aux;
    }

    @Override
    public boolean bienFormado() {
        boolean aux=true;
        int i=0;
        
        while ((i< dimL-1)&&(aux)){
            if(v[i].getTono() < v[i+1].getTono()){
                aux=false;
            }
            i++;
        }
        return aux;
    }
        
}
    
    

