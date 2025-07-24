/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4adicional;

/**
 *
 * @author Julian
 */
public abstract class Urna {
    private int votosBlanco = 0;
    private int numero;
    private Zona zona;

    public Urna(int numero, Zona zona) {
        this.numero = numero;
        this.zona = zona;
    }
    
    public void votarEnBlanco(){
        votosBlanco++;
    }

    public int getVotosBlanco() {
        return votosBlanco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
    
    public abstract int calcularGanador();
    public abstract int calcularTotalVotos();

    @Override
    public String toString() {
        return "Urna " + numero + " " + zona + " Total votos: " + this.calcularTotalVotos() + " Ganador: " + this.calcularGanador();
    }
    
    
    
}
