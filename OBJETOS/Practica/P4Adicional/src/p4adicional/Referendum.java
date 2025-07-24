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
public class Referendum extends Urna{
    private int votosAFavor = 0;
    private int votosEnContra = 0;

    public Referendum(int numero, Zona zona) {
        super(numero, zona);
    }

    public int getVotosAFavor() {
        return votosAFavor;
    }

    public int getVotosEnContra() {
        return votosEnContra;
    }
    
    public void votarAFavor(){
        votosAFavor++;
    }
    
    public void votarEnContra(){
        votosEnContra++;
    }

    @Override
    public int calcularGanador() {
        if (votosAFavor == votosEnContra){
            return 0;
        }
        else{
            if (votosEnContra > votosAFavor){
                return -1;
            }
            else{
                return 1;
            }
        }
    }

    @Override
    public int calcularTotalVotos() {
        return this.getVotosBlanco() + this.getVotosAFavor() + this.getVotosEnContra();
    }
    
    
}
