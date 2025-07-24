/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial46_2;

import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Parcial46_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funcion f = new Funcion("20:00","21/05/2002","Historia",5,5);
        
        int fi, b;
        
        for (int i = 0; i < 5; i++){
            System.out.print("Fila: ");
            fi = Lector.leerInt();
            System.out.print("Butaca: ");
            b = Lector.leerInt();
            System.out.println(f.ocuparButaca(fi,b));
        }
        
        System.out.println(f);
        System.out.println();
        
        System.out.println("Que fila queres desocupar?");
        fi = Lector.leerInt();
        f.desocuparButacas(fi);
        
        System.out.print("De que butacas queres obtener la representacion? ");
        b = Lector.leerInt();
        
        System.out.println(f.obtenerRepresentacion(b));
        System.out.println();
        System.out.println(f);
        
    }
    
}
