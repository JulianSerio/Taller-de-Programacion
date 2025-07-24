/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

import tema4.Persona;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Ej04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int DIMF = 8,DIMC = 5;
        int dni,edad,i,j;
        int c = 0, f = 0;
        String nombre;
        
        Persona [][] m = new Persona [DIMF][DIMC];

        System.out.print("NOMBRE: ");
        nombre = Lector.leerString();
        while ((!nombre.equals("ZZZ")) && (c < DIMC)){
            while (!nombre.equals("ZZZ") && (f < DIMF)){
                System.out.print("DNI: ");
                dni = Lector.leerInt();
                System.out.print("EDAD: ");
                edad = Lector.leerInt();
                System.out.println();
               
                m[f][c] = new Persona(nombre,dni,edad);
                
                System.out.println("Dia: " + c + " | Turno: " + f + " | Nombre: " + m[f][c].getNombre());
                
                f++;
                
                System.out.print("NOMBRE: ");
                nombre = Lector.leerString(); 
            }
            c++;
            f=0;
        }
    }
    
}
