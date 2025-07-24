package tema3;

import tema4.Persona;
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julian
 */
public class Ej04Hotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("DIMF:  ");
        int DIMF = Lector.leerInt();
        
        Hotel h = new Hotel(DIMF);
        
        int i,dni,edad,x;
        double aumento;
        String nombre;
        
        for (i = 0; i < 5; i++){
            nombre = GeneradorAleatorio.generarString(10);
            edad = GeneradorAleatorio.generarInt(100);
            dni = GeneradorAleatorio.generarInt(7000);
            
            System.out.println("Nombre: " + nombre + " Edad: " + edad + " Dni: " + dni);
            
            Persona c = new Persona(nombre,dni,edad);
            
            System.out.println("Nro habitacion: ");
            x = Lector.leerInt();
            h.agregarHabitacion(c,x,GeneradorAleatorio.generarDouble(5000));
        } 
       
        System.out.println(h.toString());
        
        System.out.println("Ingres monto a aumentar: ");
        aumento = Lector.leerDouble();
        h.aumentarCosto(2000);
        
   
        System.out.println(h.toString());
              
    }
    
}
