/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial302;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Julian
 */
public class Parcial302 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CompraMinorista cMin = new CompraMinorista(true,203,10);
        CompraMayorista cMay = new CompraMayorista(2424224,203,10);
        
        int codigo;
        double precio;
        String descrip;
        
        System.out.println("-----Compra minorista----");
        for (int i = 0; i < 3; i++){
            codigo = GeneradorAleatorio.generarInt(200);
            precio = GeneradorAleatorio.generarDouble(1000);
            descrip = GeneradorAleatorio.generarString(10);
            System.out.println("Codigo: " + codigo + " Precio: " + precio + " Descripcion: " + descrip);
            
            Producto p = new Producto(codigo,precio,descrip);
            
            cMin.agregarProducto(p);
            
        }
        
        System.out.println("-----Compra mayorista----");
        for (int i = 0; i < 3; i++){
            codigo = GeneradorAleatorio.generarInt(200);
            precio = GeneradorAleatorio.generarDouble(1000);
            descrip = GeneradorAleatorio.generarString(10);
            System.out.println("Codigo: " + codigo + " Precio: " + precio + " Descripcion: " + descrip);
            
            Producto p = new Producto(codigo,precio,descrip);
            
            cMay.agregarProducto(p);  
        }
        System.out.println();
        System.out.println(cMin);
        System.out.println();
        System.out.println(cMay);
        
    }
    
}
