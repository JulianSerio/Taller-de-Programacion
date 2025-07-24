/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej03;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Julian
 */
public class Ej03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        EventoOcasional eO = new EventoOcasional("Privado","Julian Serio",5,"Fito Paez",10);
        Gira g = new Gira("Giros",5,"Charly Garcia",10);
    
        for (int i = 0; i < 3; i++){
            String tema = GeneradorAleatorio.generarString(10);
            System.out.println("Tema: "+tema);
            eO.agregarTema(tema);
            
            
        }
         for (int i = 0; i < 3; i++){
            String tema = GeneradorAleatorio.generarString(10);
            g.agregarTema(tema);
            System.out.println("Tema: "+tema);
            String ciudad = GeneradorAleatorio.generarString(10);
            int dia = GeneradorAleatorio.generarInt(31) + 1;
            Fecha f = new Fecha(ciudad,dia);
            g.agregarFecha(f);
        }   
        System.out.println("Gira: "+g.calcularCosto());
        System.out.println("Evento ocacional: "+eO.calcularCosto());
        System.out.println();
        System.out.println(eO.actuar());
        System.out.println();
        System.out.println(g.actuar());
    }   
    
}
