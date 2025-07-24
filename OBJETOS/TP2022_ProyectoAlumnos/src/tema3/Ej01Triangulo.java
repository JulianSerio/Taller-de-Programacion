/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Julian
 */
import PaqueteLectura.Lector;
public class Ej01Triangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Lado 1: ");
        double lado1 = Lector.leerDouble();
        System.out.println("Lado 2: ");
        double lado2 = Lector.leerDouble();
        System.out.println("Lado 3: ");
        double lado3 = Lector.leerDouble();
        System.out.println("Color Relleno: ");
        String colorRelleno = Lector.leerString();
        System.out.println("Color Linea: ");
        String colorLinea = Lector.leerString();
        
        Triangulo t = new Triangulo(lado1,lado2,lado3,colorRelleno,colorLinea);
        
        System.out.println("Perimetro del triangulo: " + t.calcularPerimetro());
        System.out.println("Area del triangulo: " + t.calcalarArea());
        System.out.println(t);

    }
    
}
