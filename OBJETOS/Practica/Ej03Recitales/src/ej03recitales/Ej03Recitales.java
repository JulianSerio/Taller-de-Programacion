/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej03recitales;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Julian
 */
public class Ej03Recitales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventoOcacional e = new EventoOcacional("Show TV","Julian",30,"Avici",5);
        Gira g = new Gira("World Tour",5,"Los Socios",5);
        
        String ciudad,tema;
        int dia;
        
        for (int i = 0; i < 5; i++ ){
            ciudad = GeneradorAleatorio.generarString(10);
            dia = GeneradorAleatorio.generarInt(31) + 1;
            tema = GeneradorAleatorio.generarString(7);
            
            System.out.println("Ciudad " + ciudad + " Dia: " + dia + " Tema:" + tema);
            
            Fecha f = new Fecha(ciudad,dia);
            g.agregarFecha(f);
            g.agregarTema(tema);
            
            e.agregarTema(tema);
        }
        
        System.out.println(g.actuar());
        System.out.println(e.actuar());
        System.out.println("Costo Gira: "+ g.calcularCosto());
        System.out.println("Costo Evento Ocacional: " + e.calcularCosto());
    }
    
}
