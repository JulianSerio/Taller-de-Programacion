/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial29;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Parcial29 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ingrese DIMF: ");
        int DIMF = Lector.leerInt();
        Minorista min = new Minorista(false,DIMF,203);
        Mayorista max = new Mayorista(42231,DIMF,204);
        
        
        int codigo;
        double precio;
        String descripcion;
        
        for (int i = 0; i < 3; i++){
            codigo = GeneradorAleatorio.generarInt(100);
            precio = GeneradorAleatorio.generarDouble(1000);
            descripcion = GeneradorAleatorio.generarString(10);
            
            System.out.println("Codigo: " + codigo + " Precio: " + precio + " Decripcion: " + descripcion);
            
            Producto p = new Producto(codigo,precio,descripcion);
            
            min.agregarProdcuto(p);
        }
        for (int i = 0; i < 3; i++){
            codigo = GeneradorAleatorio.generarInt(100);
            precio = GeneradorAleatorio.generarDouble(1000);
            descripcion = GeneradorAleatorio.generarString(10);
            
            System.out.println("Codigo: " + codigo + " Precio: " + precio + " Decripcion: " + descripcion);
            
            Producto p = new Producto(codigo,precio,descripcion);
            
            max.agregarProdcuto(p);
        }
        System.out.println();
        System.out.println(min);
        System.out.println();
        System.out.println(max);


    }
    
}
