/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema5.ej02;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Ej02Estacionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estacionamiento e = new Estacionamiento("HOTEL AUTOS","7 Y 50", "8:00", "21:00",3,3);
        String patente, nombre;
        int x,y;
        
        for (int i = 0; i < 6; i++){
            patente = GeneradorAleatorio.generarString(7);
            nombre = GeneradorAleatorio.generarString(15);
            System.out.println("Nombre: " + nombre +  " Patente: " + patente);
            
            Auto a = new Auto(nombre,patente);
            
            System.out.print("Ingrese PISO (1..3): ");
            x = Lector.leerInt();
            System.out.print("Ingrese PLAZA (1..3): ");
            y = Lector.leerInt();
            e.agregarAuto(a, x, y);
        }
        
        System.out.println(e.toString());
        System.out.println("Cantidad de autos en la plaza 1: " + e.cantAutosPlaza(1));
        System.out.println();
        System.out.print("Ingrese patente a buscar: ");
        patente = Lector.leerString();
        System.out.println(e.buscarPatente(patente));
    }
    
}
