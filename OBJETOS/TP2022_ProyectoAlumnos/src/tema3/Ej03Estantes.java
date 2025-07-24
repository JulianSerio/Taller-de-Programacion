/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Ej03Estantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estante e = new Estante();
        String titulo,ISBN,editorial,nombre,biografia,origen;
        int anio;
        double precio;
        
        System.out.print("TITULO: ");
        titulo = Lector.leerString();
        
        while (!titulo.equals("ZZZ") && (e.getDimL() < e.getDIMF())){
            precio = GeneradorAleatorio.generarDouble(200);
            ISBN = GeneradorAleatorio.generarString(8);
            anio = GeneradorAleatorio.generarInt(3000);
            editorial = GeneradorAleatorio.generarString(8);

            System.out.println("ISBN: " + ISBN);   
            System.out.println("EDITORIAL: " + editorial);
            System.out.println("ANIO: " + anio);
            System.out.println("PRECIO:" + precio);
            
            System.out.print("-- AUTOR: ");
            nombre = Lector.leerString();
            System.out.print("-- BIOGRAFIA: ");
            biografia = Lector.leerString();
            System.out.print("-- ORIGEN: ");
            origen = Lector.leerString();
            
            Autor a = new Autor (nombre,biografia,origen);
            
            e.agregarLibro(titulo, editorial, anio, a, ISBN, precio);
            
            System.out.print("TITULO: ");
            titulo = Lector.leerString();
        }
        e.imprimirVector();
        System.out.println();
        System.out.println(e.buscarTitulo("Mujercitas"));
  
    }
    
}
