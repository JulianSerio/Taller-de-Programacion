/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial31;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Julian
 */
public class Parcial31 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mayorista max = new Mayorista(42423,203,10);
        Minorista min = new Minorista(false,204,10);
        
        
        int codigo;
        double precio;
        String descripcion;

        
        for (int i = 0; i < 3; i++){
            codigo = GeneradorAleatorio.generarInt(100);
            precio = GeneradorAleatorio.generarDouble(1000);
            descripcion = GeneradorAleatorio.generarString(10);
            
            System.out.println("Codigo: " + codigo + " Precio: " + precio + " Descripcion: " + descripcion);
            
            Producto p = new Producto(codigo,precio,descripcion);
            
            max.agregarProducto(p);
        }
        System.out.println();
        for (int i = 0; i < 3; i++){
            codigo = GeneradorAleatorio.generarInt(100);
            precio = GeneradorAleatorio.generarDouble(1000);
            descripcion = GeneradorAleatorio.generarString(10);
            
            System.out.println("Codigo: " + codigo + " Precio: " + precio + " Descripcion: " + descripcion);
            
            Producto p = new Producto(codigo,precio,descripcion);
            
            min.agregarProducto(p);
        }
        System.out.println();
        System.out.println(max);
        System.out.println();
        System.out.println(min);
    }
}
