/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Julian
 */
public class Ej01Figuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Triangulo t = new Triangulo(2,4,4,"Azul","Cian");
        Circulo c = new Circulo(8,"Verde","Rojo");
        
        System.out.println(t.toString());
        System.out.println(c.toString());
        
        c.despintar();
        t.despintar();
        
        System.out.println(t.toString());
        System.out.println(c.toString());

    }
    
}
