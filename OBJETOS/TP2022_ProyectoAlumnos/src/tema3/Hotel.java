/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import tema4.Persona;

/**
 *
 * @author Julian
 */
public class Hotel {
    private int DIMF;
    private Habitacion []v;

    public Hotel(int DIMF) {
        this.DIMF = DIMF;
        this.v = new Habitacion[DIMF];
        inicializo();
    }
    
    public void inicializo (){
        for (int i = 0; i < DIMF; i++){
            v[i] = new Habitacion();
        }
    }
    
    public void agregarHabitacion (Persona c, int i, double costo){
        v[i] = new Habitacion(costo,true,c);
    }
    
    public void aumentarCosto (double aumento){
        for (int i = 0; i < DIMF; i++){
            v[i].setCosto(v[i].getCosto() + aumento);
        }
    }

    public int getDIMF() {
        return DIMF;
    }

    public void setDIMF(int DIMF) {
        this.DIMF = DIMF;
    }

    public Habitacion[] getV() {
        return v;
    }

    public void setV(Habitacion[] v) {
        this.v = v;
    }
    
    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < DIMF; i++){
            
            if (v[i].isOcupada()){
                aux = aux + "Habitacion " + i + " costo: " + v[i].getCosto() + " ocupada: " + v[i].isOcupada() + " cliente: " + v[i].getCliente() + '\n';
            }
            else{ 
                aux = aux + "Habitacion " + i + " costo: " + v[i].getCosto() + " libre: " + '\n';
            }  
        }
        return aux;
    }
}