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
public class UrnaReferendum extends Urna{
    private int votosFavor = 0;
    private int votosContra = 0;

    public UrnaReferendum(int numero, Zona zona) {
        super(numero, zona);
    }

    public int getVotosFavor() {
        return votosFavor;
    }

    public void setVotosFavor(int votosFavor) {
        this.votosFavor = votosFavor;
    }

    public int getVotosContra() {
        return votosContra;
    }

    public void setVotosContra(int votosContra) {
        this.votosContra = votosContra;
    }
    
    public void votarAFavor(){
        this.votosFavor++;
    }
    
    public void votarEnContra(){
        this.votosContra++;
    }


    @Override
    public int calcularGanador() {
        if (this.votosContra == this.votosFavor){
            return 0;
        }
        else{
            if (this.votosContra > this.votosFavor){
                return -1;
            }
            else{
                return 1;
            }
        }
    }

    @Override
    public int calcularTotalVotos() {
        return super.getVotosBlanco() + this.votosContra + this.votosFavor;

    }
    
}
