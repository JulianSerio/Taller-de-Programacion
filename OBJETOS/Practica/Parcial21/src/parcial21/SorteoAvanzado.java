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
public class SorteoAvanzado extends Sorteo{

    public SorteoAvanzado(double premio) {
        super(premio);
    }

    @Override
    public Persona ejecutarSorteo() {
        double max = -1;
        Persona winner = null;
        for (int i = 0; i < super.getNroBonos(); i++){
            if (this.obtenerPersona(i).getAporte() > max){
                max = this.obtenerPersona(i).getAporte();
                winner = this.obtenerPersona(i);
            }
        }
        return winner;
    }
    
    
    
}
