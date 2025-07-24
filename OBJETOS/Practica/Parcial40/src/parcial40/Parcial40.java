/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial40;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Parcial40 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Estanteria es = new Estanteria(5,3);
        String titulo, autor;
        double peso;
        int x,y;
        
        for (int i = 0; i < 7; i++){
            titulo = GeneradorAleatorio.generarString(10);
            autor = GeneradorAleatorio.generarString(10);
            peso = GeneradorAleatorio.generarDouble(10) + 1;
            
            System.out.println("Titulo: " + titulo + " Autor: " + autor + " Peso: " + peso);
            
            Libro l = new Libro(titulo,autor,peso);
            
            es.agregarLibro(l);
        }
        System.out.println(es);
        System.out.println();
        System.out.println("Ingrese X:");
        x = Lector.leerInt();
        System.out.println("Ingrese Y:");
        y = Lector.leerInt();
        System.out.println(es.sacarLibro(x, y));
        System.out.println();
        System.out.println(es.calcular("Borges"));
    }
    
}
