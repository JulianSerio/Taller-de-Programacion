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
import PaqueteLectura.GeneradorAleatorio;
public class SorteoComun extends Sorteo{

    public SorteoComun(double premio) {
        super(premio);
    }
    

    @Override
    public String ejecutarSorteo() {
        int numGanador = GeneradorAleatorio.generarInt(super.getNum());
        return "Premio Neto: " + super.premioNeto() + " Ganador: " + super.obtenerPersona(numGanador);
        
    }
    
    
    
}
