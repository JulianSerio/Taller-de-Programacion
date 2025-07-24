/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriojulian;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class SerioJulian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estanteria e = new Estanteria(5,3);
        
        String titulo,autor;
        double peso;
        int x,y;
        
        for (int i = 0; i < 7; i++){
            titulo = GeneradorAleatorio.generarString(10);
            autor = Lector.leerString();
            //autor = GeneradorAleatorio.generarString(10);
            peso = GeneradorAleatorio.generarDouble(10);
            
            System.out.println("Titulo: " + titulo + " Autor: " + autor + " Peso: " + peso);
            
            Libro l = new Libro(titulo,autor,peso);
            
            e.almacenarLibro(l);
        }
        System.out.println();
        System.out.println(e);
        System.out.println("Estante: ");
        x = Lector.leerInt();
        System.out.println("Lugar: ");
        y = Lector.leerInt();
        System.out.println(e.sacarLibro(x, y));
        System.out.println();
        System.out.println(e);
        System.out.println("Cantidad de libros Borges: "+ e.calcular("Borges"));

    }
    
}
