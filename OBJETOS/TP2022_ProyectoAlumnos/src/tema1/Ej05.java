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
public class Ej05 {
    public static void main (String[] args){
        int DIMF = 5;
        int DIMC = 4;
        int [][]m = new int [DIMF][DIMC];
        
        int i,j;
        
        for (i = 0; i < DIMF; i++){
            for (j = 0; j < DIMC; j++){
                System.out.print("Puntaje: ");
                m[i][j] = Lector.leerInt();
            }
            System.out.println();
        }
        
        for (i = 0; i < DIMF; i++){
            for (j = 0; j < DIMC; j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        int suma;
        int prom;
        for (i = 0; i < DIMC; i++){
            suma = 0;
            prom = 0;
            for (j = 0; j < DIMF; j++){
                suma = suma + m[j][i];
            }
            prom = suma / DIMF;
            System.out.println("El promedio del aspecto " + i + " es " + prom);
        }

    }
    
}
