/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adicionales;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Ej04P3 {
    public static void main (String[] args){
        System.out.print("Ingrese DIMF: ");
        int DIMF = Lector.leerInt();
        Hotel h = new Hotel(DIMF);
        
        int i,edad,dni,x;
        String nombre;
        double aumento;
        
        for (i = 0; i < 5; i++){
            nombre = GeneradorAleatorio.generarString(10);
            edad = GeneradorAleatorio.generarInt(100) + 1;
            dni = GeneradorAleatorio.generarInt(50000);
            
            Persona c = new Persona(nombre,dni,edad);
            
            System.out.println("Nombre: " + nombre + " edad: " + edad + " dni: " + dni);
            
            System.out.print("Ingrese Nro: ");
            x = Lector.leerInt();
            
            h.agregarCliente(c, x);
        }
        
        System.out.println(h);
        
        System.out.println("Ingrese aumento: ");
        aumento = Lector.leerDouble();
        h.aumentarPrecio(aumento);
        
        System.out.println(h);
        
    }
    
}
