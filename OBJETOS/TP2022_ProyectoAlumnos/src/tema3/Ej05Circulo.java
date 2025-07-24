/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Ej05Circulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Radio: ");
        double radio = Lector.leerDouble();
        System.out.print("Color Relleno: ");
        String colorRelleno = Lector.leerString();
        System.out.print("Color Linea: ");
        String colorLinea = Lector.leerString();
        
        Circulo c = new Circulo(radio,colorRelleno,colorLinea);
        
        System.out.println("Area: "+c.calcularArea());
        System.out.println("Perimetro: "+c.calcularPerimetro());
        System.out.println(c.toString());
    }
    
}
