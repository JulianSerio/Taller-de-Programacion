/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

/**
 *
 * @author Julian
 */

import tema4.Persona;
import PaqueteLectura.Lector;

public class Ej01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona p = new Persona();
        
        System.out.println("DNI: ");
        int dni = Lector.leerInt();
        p.setDNI(dni);
        
        System.out.println("EDAD: ");
        int edad = Lector.leerInt();
        p.setEdad(edad);
        
        System.out.println("NOMBRE: ");
        String nombre = Lector.leerString();
        p.setNombre(nombre);
        
        System.out.println(p.toString());
        
        
    }
    
}
