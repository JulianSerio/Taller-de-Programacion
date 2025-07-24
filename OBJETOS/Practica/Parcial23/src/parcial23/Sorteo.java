/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial23;

/**
 *
 * @author Julian
 */
public abstract class Sorteo {
    private double premio;
    private int num = 0;
    private int DIMF = 100;
    private Persona []v = new Persona[DIMF];

    public Sorteo(double premio) {
        this.premio = premio;
    }
    
    public int agregarPersona(Persona p){
        v[num] = p;
        num++;
        return num;
    }
    
    public double premioNeto(){
        double aux = (premio * 21) / 100;
        return premio - aux;
    }
    
    public Persona obtenerPersona(int B){
        return v[B];
    }
    
    
    
    public abstract String ejecutarSorteo();

    public int getNum() {
        return num;
    }

    public int getDIMF() {
        return DIMF;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }
    
    
    
}
