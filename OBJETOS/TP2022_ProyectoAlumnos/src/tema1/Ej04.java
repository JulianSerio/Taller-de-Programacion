/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

/**
 *
 * @author Julian
 */
import PaqueteLectura.Lector;

public class Ej04 {
    public static void main (String[] args){
        int DIMF = 8;
        int DIMC = 4;
        int [][]m = new int [DIMF][DIMC];
        
        int i,j;
        
        for (i = 0; i < DIMF; i++){
            for (j = 0; j < DIMC; j++){
                m[i][j] = 0;
            }
        }
        System.out.println("Ingrese piso: ");
        int piso = Lector.leerInt();
        while (piso != 9){
            System.out.println("Ingrese oficina: ");
            int oficina = Lector.leerInt();
            m[piso][oficina]++;
            System.out.println("Ingrese piso: ");
            piso = Lector.leerInt();
        }
        
        for (i = 0; i < DIMF; i++){
            for (j = 0; j < DIMC; j++){
                System.out.print(m[i][j] + "");
            }
            System.out.println();
        }
    }
    
}
