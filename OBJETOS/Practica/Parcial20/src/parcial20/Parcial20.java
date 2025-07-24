/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial20;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Julian
 */
public class Parcial20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Catalogo c = new Catalogo();
        
        String nombre,obra;
        
        for (int i = 0; i < 2; i++){
            nombre = GeneradorAleatorio.generarString(10);
            obra = GeneradorAleatorio.generarString(10);
            System.out.println("Nombre: " + nombre + " Obra: " + obra);
            
            Artista a = new Artista(nombre,obra);
            
            c.agregarArtista(a);
        }
        System.out.println(c);
    
    }
    
}
