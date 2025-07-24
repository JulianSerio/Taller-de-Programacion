/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial28;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Julian
 */
public class Parcial28 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        Minorista min = new Minorista(true,203,10);
        Mayorista may = new Mayorista(232324,204,10);
        
        int i,codigo;
        double precioMay,precioMin;
        
        for (i = 0; i < 3; i++){
            codigo = GeneradorAleatorio.generarInt(10);
            precioMin = GeneradorAleatorio.generarDouble(1000);
            precioMay = GeneradorAleatorio.generarDouble(1000);
            
            System.out.println("Codigo: " + codigo + " Precio Min: " + precioMin + " Precio May: " + precioMay);
            
            Producto p = new Producto(codigo,precioMay,precioMin);
            
            min.agregarProducto(p);
            
        }
        System.out.println();
        for (i = 0; i < 3; i++){
            codigo = GeneradorAleatorio.generarInt(10);
            precioMin = GeneradorAleatorio.generarDouble(1000);
            precioMay = GeneradorAleatorio.generarDouble(1000);
            
            System.out.println("Codigo: " + codigo + " Precio Min: " + precioMin + " Precio May: " + precioMay);
            
            Producto p = new Producto(codigo,precioMay,precioMin);
            
            may.agregarProducto(p);
            
        }
        System.out.println(min);
        System.out.println();
        System.out.println(may);
    }
    
}
