/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial17;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Parcial17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Catalogo c = new Catalogo();
        String nombre,categoria;
        
        for (int i = 0; i < 3; i++){
            nombre = GeneradorAleatorio.generarString(10);
            System.out.println("Ingrese categoria: ");
            categoria = Lector.leerString();
            
            Artista a = new Artista(nombre,categoria);
            
            c.agregarArtista(a);
            
        }
        
        System.out.println("CATEGORIA: ");
        categoria = Lector.leerString();
        System.out.println(c.cantArtistas(categoria));
    }
    
}
