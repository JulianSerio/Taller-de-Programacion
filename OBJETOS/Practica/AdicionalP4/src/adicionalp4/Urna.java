/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adicionalp4;

/**
 *
 * @author Julian
 */
public abstract class Urna {
    private int numero;
    private int votosBlanco = 0;
    private Zona zona;

    public Urna(int numero, Zona zona) {
        this.numero = numero;
        this.zona = zona;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getVotosBlanco() {
        return votosBlanco;
    }

    public void setVotosBlanco(int votosBlanco) {
        this.votosBlanco = votosBlanco;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
    
    public void votarEnBlanco(){
        this.votosBlanco++;
    }
    
    public abstract int calcularGanador();
    public abstract int calcularTotalVotos();

    @Override
    public String toString() {
        return "Urna{" + "numero= " + numero + " zona= " + zona + " total votos= " + this.calcularTotalVotos() + " Ganador= " + this.calcularGanador() + '}';
    }
    
    
    
}
