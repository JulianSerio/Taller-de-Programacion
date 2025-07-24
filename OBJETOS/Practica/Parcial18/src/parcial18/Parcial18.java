/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial18;

/**
 *
 * @author Julian
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Parcial18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Catalogo c = new Catalogo();
        
        String nacionalidad,nombre;
        int C;
        
        for (int i = 0; i < 2; i++){
            nombre = GeneradorAleatorio.generarString(10);
            nacionalidad = GeneradorAleatorio.generarString(10);
            
            System.out.println("Nombre: " + nombre + " Nacionalidad: " + nacionalidad);
            
            Artista a = new Artista(nacionalidad,nombre);
            
            System.out.println("Ingrese CATEGORIA: ");
            C = Lector.leerInt();
            c.agregarArtista(a, C);
        }
        System.out.println(c);
    }
    
}
