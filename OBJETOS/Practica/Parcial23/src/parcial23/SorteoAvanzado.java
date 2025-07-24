/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial23;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Julian
 */
public class SorteoAvanzado extends Sorteo {

    public SorteoAvanzado(double premio) {
        super(premio);
    }
    

    @Override
    public String ejecutarSorteo() {
        int num1 = GeneradorAleatorio.generarInt(super.getNum());
        int num2 = GeneradorAleatorio.generarInt(super.getNum());
        
        return "Premio Neto: " + super.premioNeto() + " Ganador 1: " + super.obtenerPersona(num1) + " Ganador 2: " + super.obtenerPersona(num2);
    }
    
}
