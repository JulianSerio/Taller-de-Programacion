/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial39;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Parcial30 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        Concurso c = new Concurso(2);
        String nombre1,nombre2,estilo;
        int edad1,edad2,dni1,dni2;
        
        
        for (int i = 0; i < 2; i ++){
            nombre1 = GeneradorAleatorio.generarString(10);
            nombre2 = GeneradorAleatorio.generarString(10);
            dni1 = GeneradorAleatorio.generarInt(10000);
            dni2 = GeneradorAleatorio.generarInt(10000);
            estilo = GeneradorAleatorio.generarString(10);
            System.out.println("Nombre 1: " + nombre1 + " Nombre 2: " + nombre2);
            System.out.println("Ingrese edad participante 1: ");
            edad1 = Lector.leerInt();
            System.out.println("Ingrese edad participante 2: ");
            edad2 = Lector.leerInt();
            
            Participante p1 = new Participante(dni1,edad1,nombre1);
            Participante p2 = new Participante(dni2,edad2,nombre2);
            
            Pareja par = new Pareja(p1,p2,estilo);
            
            c.agregarPareja(par);
            
        }
        System.out.println(c.mayorDiffEdad());
    }
    
}
