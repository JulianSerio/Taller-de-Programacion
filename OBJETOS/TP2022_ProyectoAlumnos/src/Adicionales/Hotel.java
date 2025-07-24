/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adicionales;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Julian
 */
public class Hotel {
    private int DIMF;
    private Habitacion []v;

    public Hotel(int DIMF) {
        this.DIMF = DIMF;
        v = new Habitacion[DIMF];
        this.inicializar();
    }
    
    private void inicializar(){
        for (int i = 0; i < DIMF; i++){
            v[i] = new Habitacion(GeneradorAleatorio.generarDouble(6001) + 2000);
        }
    }
    
    public void agregarCliente (Persona c, int x){
        v[x].setCliente(c);
        v[x].setOcupada(true);
    }

    public int getDIMF() {
        return DIMF;
    }
    
    public void aumentarPrecio(double aumento){
        for (int i = 0; i < DIMF; i++){
            v[i].aumentoPrecio(aumento);
        }
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < DIMF; i++){
            aux = aux + "Habitacion " + i + " " + v[i] + "\n";
        }
        return aux;
    }
    
    
    
    
    
    
}
