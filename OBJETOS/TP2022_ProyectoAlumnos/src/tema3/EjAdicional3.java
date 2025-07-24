/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class EjAdicional3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        System.out.print("Ingrese maximo alumnos: ");
        int COLUMNAS = Lector.leerInt();
        Concurso c = new Concurso(COLUMNAS);
        
        int edad,i,genero;
        String nombre,instrumento;
        double puntaje;
        
        for (i = 0; i < 5; i++){
            nombre = GeneradorAleatorio.generarString(10);
            instrumento = GeneradorAleatorio.generarString(10);
            puntaje = GeneradorAleatorio.generarDouble(10) + 1;
            edad = GeneradorAleatorio.generarInt(100) + 1;
            
            System.out.println("Nombre: " + nombre + " Instrumento: " + instrumento + " Puntaje: " + puntaje);
            Alumno a = new Alumno(nombre,edad,instrumento,puntaje);
            
            System.out.print("Ingrese genero (0..4): ");
            genero = Lector.leerInt();
            c.inscribirAlu(a, genero); 
        }
        System.out.println(c);
        System.out.println();
        System.out.print("Ingrese genero valido: ");
        genero = Lector.leerInt();
        System.out.print("Ingrese nombre de alumno: ");
        nombre = Lector.leerString();
        System.out.print("Ingrese puntaje: ");
        puntaje = Lector.leerDouble();
        
        c.asignoPuntaje(genero, nombre, puntaje);
        
        System.out.println(c);
    }
    
}
