/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial46;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Parcial46 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();;
        Fecha f = new Fecha(2,4);
        String nombre;
        int dni,s;
        
        for (int i = 0; i < 5; i++){
            nombre = GeneradorAleatorio.generarString(10);
            dni = GeneradorAleatorio.generarInt(10000);
            
            System.out.println("Nombre: " + nombre + " Dni:" + dni);
            
            Alumno a = new Alumno(nombre,dni);
            
            System.out.println("Ingrese sala (0..1)");
            s = Lector.leerInt();
            
            f.agregarAlumno(a,s);
            
        }
        f.asignarTurno();
        System.out.println(f);
    }
        
    
}
