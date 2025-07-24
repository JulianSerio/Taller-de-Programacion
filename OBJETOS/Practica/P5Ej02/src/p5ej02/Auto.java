/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5ej02;

/**
 *
 * @author Julian
 */
public class Auto {
    private String dueno;
    private String patente;

    public Auto(String dueno, String patente) {
        this.dueno = dueno;
        this.patente = patente;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "Auto{" + "dueno=" + dueno + ", patente=" + patente + '}';
    }
    
    
    
}
