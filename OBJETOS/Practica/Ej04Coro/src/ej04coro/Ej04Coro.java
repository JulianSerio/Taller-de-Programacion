/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej04coro;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Ej04Coro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        Director d = new Director("Juan",44323,41,42);
        CoroSemicircular cS = new CoroSemicircular(4,"Pipi",d);
        CoroPorHileras cH = new CoroPorHileras(2,2,"Popi",d);
        
        String nombre;
        int dni,edad,tono;
        System.out.println("---- CARGAR VECTOR ----");
        for (int i = 0; i < 4; i++){
            nombre = GeneradorAleatorio.generarString(10);
            dni = GeneradorAleatorio.generarInt(10);
            edad = GeneradorAleatorio.generarInt(10);
            
            System.out.println("Ingrese tono fundamental: ");
            tono = Lector.leerInt();
            
            System.out.println("Nombre: " + nombre + " Dni: " + dni + " Edad: " + edad + " Tono: " + tono);
            
            Corista c = new Corista(nombre,dni,edad,tono);
            
            cS.agregarCorista(c); 
        }
        System.out.println("----CARGAR MATRIZ----");
        
        for (int i = 0; i < 4; i++){
            nombre = GeneradorAleatorio.generarString(10);
            dni = GeneradorAleatorio.generarInt(10);
            edad = GeneradorAleatorio.generarInt(10);
            
            System.out.println("Ingrese tono fundamental: ");
            tono = Lector.leerInt();
            
            System.out.println("Nombre: " + nombre + " Dni: " + dni + " Edad: " + edad + " Tono: " + tono);
            
            Corista c = new Corista(nombre,dni,edad,tono);
            
            cH.agregarCorista(c); 
        }
        
        System.out.println(cS);
        System.out.println();
        System.out.println(cH);
        System.out.println();
        System.out.println(cS.bienFormado());
        System.out.println(cH.bienFormado());
        

    }
    
}
