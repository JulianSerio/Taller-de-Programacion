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
public class Parcial21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        SorteoComun sC = new SorteoComun(50000);
        SorteoAvanzado sA = new SorteoAvanzado(50000);
        
        String nombre;
        int dni;
        double aporte;
        
        for (int i = 0; i < 3; i++ ){
            nombre = GeneradorAleatorio.generarString(10);
            dni = GeneradorAleatorio.generarInt(100000);
            aporte = GeneradorAleatorio.generarDouble(1000);
            
            System.out.println("Nombre: " + nombre + " Dni: " + dni + " Aporte: " + aporte);
            Persona p = new Persona(nombre,dni,aporte);
            
            System.out.println(sC.agregarPersona(p));
        }
        for (int i = 0; i < 3; i++ ){
            nombre = GeneradorAleatorio.generarString(10);
            dni = GeneradorAleatorio.generarInt(100000);
            aporte = GeneradorAleatorio.generarDouble(1000);
            
            System.out.println("Nombre: " + nombre + " Dni: " + dni + " Aporte: " + aporte);
            Persona p = new Persona(nombre,dni,aporte);
            
            System.out.println(sA.agregarPersona(p));
        }
        System.out.println();

        System.out.println(sC.ejecutarSorteo());
        System.out.println(sA.ejecutarSorteo());


        
            
    }
    
}
