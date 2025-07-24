/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial21;

/**
 *
 * @author Julian
 */
public abstract class Sorteo {
    private double premio;
    private int nroBonos = 0;
    private int DIMF = 100;
    private Persona []v = new Persona[DIMF];

    public Sorteo(double premio) {
        this.premio = premio;
        //inicilizo vector en null;
    }
    
    public int agregarPersona(Persona p){
        int aux = nroBonos;
        v[nroBonos] = p;
        nroBonos++;
        return aux;
    }
    
    public Persona obtenerPersona(int B){
        return v[B];
    }
    
    public abstract Persona ejecutarSorteo();

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public int getNroBonos() {
        return nroBonos;
    }

    public int getDIMF() {
        return DIMF;
    }
    
    
}
