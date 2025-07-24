/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial9;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Parcial9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        Estanteria e = new Estanteria(5,3);
        
        String titulo,autor;
        double peso;
        int es;
        Libro li;
        
        for (int i = 0; i < 7; i++){
            titulo = GeneradorAleatorio.generarString(10);
            autor = GeneradorAleatorio.generarString(10);
            peso = GeneradorAleatorio.generarDouble(20) + 1;
            
            System.out.println("Titulo: " + titulo + " Autor: " + autor + " Peso: " + peso);
            
            Libro l = new Libro(titulo,autor,peso);
            
            System.out.println("Ingrese estante: ");
            es = Lector.leerInt();
            
            e.almacenarLibro(l, es);
        }
        System.out.println(e);
        li = e.sacarLibro(1, 2);
        System.out.println(li);
        System.out.println("El estante con mas peso es: "+e.calcular());
    }
    
}
