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
public class Ej02Empleados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jugador j = new Jugador(10,20,"Juan Carlos",2000,20);
        Entrenador e = new Entrenador(10,"Campanella",3000,10);
        
        System.out.println(j);
        System.out.println();
        System.out.println(e);

    }
    
}
