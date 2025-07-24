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
public class Parcial23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        SorteoComun sC = new SorteoComun(50000);
        SorteoAvanzado sA = new SorteoAvanzado(50000);
        
        String nombre;
        int dni;
        double colaboracion;
        
        for (int i = 0; i < 5; i++){
            nombre = GeneradorAleatorio.generarString(10);
            dni = GeneradorAleatorio.generarInt(10000);
            colaboracion = GeneradorAleatorio.generarDouble(1000);
            
            System.out.println("Nombre: " + nombre + " Dni: " + dni + " Colaboracion: " + colaboracion);
            
            Persona p = new Persona(nombre,dni,colaboracion);
            
            System.out.println(sC.agregarPersona(p));
            
        }
        for (int i = 0; i < 5; i++){
            nombre = GeneradorAleatorio.generarString(10);
            dni = GeneradorAleatorio.generarInt(10000);
            colaboracion = GeneradorAleatorio.generarDouble(1000);
            
            System.out.println("Nombre: " + nombre + " Dni: " + dni + "Colaboracion: " + colaboracion);
            
            Persona p = new Persona(nombre,dni,colaboracion);
            
            System.out.println(sA.agregarPersona(p));
            
        }
        System.out.println(sC.ejecutarSorteo());
        System.out.println(sA.ejecutarSorteo());
    }
    
}
