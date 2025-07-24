/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial21;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Julian
 */
public class SorteoComun extends Sorteo{

    public SorteoComun(double premio) {
        super(premio);
        GeneradorAleatorio.iniciar();
    }
    
    @Override
    public Persona ejecutarSorteo() {
        int aux = GeneradorAleatorio.generarInt(super.getNroBonos());
        System.out.println(aux);
        return this.obtenerPersona(aux);
    }
    
    
}
