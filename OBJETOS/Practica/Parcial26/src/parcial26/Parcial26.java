/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial26;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Julian
 */
public class Parcial26 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CompraMinorista cMin = new CompraMinorista(true,203,10);
        CompraMayorista cMax = new CompraMayorista(232132324,204,10);
        
        double precioMin,precioMax;
        int codigo;
        
        System.out.println("---MINORISTA---");
        for (int i = 0; i < 3; i++){
            codigo = GeneradorAleatorio.generarInt(1000);
            precioMin = GeneradorAleatorio.generarDouble(1000);
            precioMax = GeneradorAleatorio.generarDouble(1000); 
            
            System.out.println("Codigo: " + codigo + " Precio min: " + precioMin + " Precio max: " + precioMax);
            
            Producto p = new Producto(codigo,precioMax,precioMin);
            
            cMin.agregarProducto(p); 
        }
        
        System.out.println("---MAYORISTA----");
        for (int i = 0; i < 3; i++){
            codigo = GeneradorAleatorio.generarInt(1000);
            precioMin = GeneradorAleatorio.generarDouble(1000);
            precioMax = GeneradorAleatorio.generarDouble(1000); 
            
            System.out.println("Codigo: " + codigo + " Precio min: " + precioMin + " Precio max: " + precioMax);
            
            Producto p = new Producto(codigo,precioMax,precioMin);
            
            cMax.agregarProducto(p); 
        }
        System.out.println();
        System.out.println(cMin);
        System.out.println();
        System.out.println(cMax);
    }
    
}
