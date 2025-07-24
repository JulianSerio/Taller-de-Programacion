/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5ej02;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class P5Ej02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estacionamiento e = new Estacionamiento("Hotel autos","7 y 60","8:00","21:00",3,3);
        
        String nombre, patente;
        int x, y;
        
        for (int i = 0; i < 6; i++){
            nombre = GeneradorAleatorio.generarString(10);
            patente = GeneradorAleatorio.generarString(10);
            
            System.out.println("Nombre: " + nombre + " Patente: " + patente);
            
            Auto a = new Auto(nombre,patente);
            
            System.out.println("Ingrese X: ");
            x = Lector.leerInt();
            System.out.println("Ingrese Y: ");
            y = Lector.leerInt();
            
            e.agregarAuto(a, x, y);

        }
        System.out.println(e);
        System.out.println();
        System.out.println(e.cantAutos(1));
        System.out.println();
        System.out.println("Ingrese patente: ");
        patente = Lector.leerString();
        System.out.println(e.obtenerRepresentacion(patente));
    }
}
