/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej03;

/**
 *
 * @author Julian
 */
public abstract class Recital {
    private String banda;
    private int DIMF;
    private String []v;

    public Recital(String banda, int DIMF) {
        this.banda = banda;
        this.DIMF = DIMF;
        v = new String[DIMF];
    }
    
    public void agregarTema(String tema){
        int i = 0;
        while (v[i] != null){
            i++;
        }
        v[i] = tema;
    }
  
    
    public String actuar(){
        String aux ="" + '\n';
        for (int i = 0; i < DIMF; i++){
            if (v[i] != null){
                aux = aux + " y ahora tocaremos..."  + v[i] + '\n';
            }
        }
        return aux;   
    }
    public abstract double calcularCosto();

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public int getDIMF() {
        return DIMF;
    }
   
}
