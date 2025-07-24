/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial47;

import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Parcial47 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Funcion f = new Funcion("La Milanesa","20-5-2022","19:00",5,5);
       
       int F,B;
       
       for (int i = 0; i < 5; i++){
           System.out.println("Ingrese Fila (0..4): ");
           F = Lector.leerInt();
           System.out.println("Ingrese Butaca (0..4): ");
           B = Lector.leerInt();
           
           System.out.println(f.ocuparButaca(F, B));
           
       }
       
        System.out.println(f);
        
        System.out.println();
        
        System.out.println("Ingrese Fila (0..4): ");
        F = Lector.leerInt();
        f.desocuparButacas(F);
        
        System.out.println("Ingrese Butaca (0..4): ");
        B = Lector.leerInt();
        System.out.println(f.representacion(B));
        
        System.out.println();
        
        System.out.println(f);
    }
    
}
