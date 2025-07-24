/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej02estacionamiento;

/**
 *
 * @author Julian
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Ej02Estacionamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estacionamiento e = new Estacionamiento("Estacionamiento","8:00","21:00","6 y 60",3,3);
        
        String nombre,patente;
        int X,Y;
        
        for (int i = 0; i < 6; i++){
            nombre = GeneradorAleatorio.generarString(10);
            patente = GeneradorAleatorio.generarString(10);
            
            System.out.println("Nombre: " + nombre + " Patente: " + patente);
            
            Auto a = new Auto(nombre,patente);
            
            System.out.println("Ingrese Piso (0..2): ");
            X = Lector.leerInt();
            System.out.println("Ingrese Plaza (0..2): ");
            Y = Lector.leerInt();
            
            e.agregarAuto(X, Y, a);
            
        }
        System.out.println(e);
         System.out.println();
        System.out.println("Cantidad de autos en la plaza 1: " + e.cantAutos(1));
        System.out.println("Ingrese patente a buscar: ");
        patente = Lector.leerString();
        System.out.println(e.buscarPatente(patente));
    }
    
}
