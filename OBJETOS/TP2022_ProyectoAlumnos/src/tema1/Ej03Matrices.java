/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

//Paso 1. importar la funcionalidad para generar datos aleatorios
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ej03Matrices {

    public static void main(String[] args) {
	//Paso 2. iniciar el generador aleatorio     
	GeneradorAleatorio.iniciar();
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        int DIMF = 5;
        int DIMC = 5;
        int [][]m = new int [DIMF][DIMC];
        int [] v = new int [DIMF];
        boolean encontre = false;
        int i,j,indiceI = 0,indiceJ = 0,aux;
        int suma = 0;
        
        for (i = 0; i < DIMF; i++){
            for (j = 0; j < DIMC; j++){
                m[i][j] = GeneradorAleatorio.generarInt(31);
            }
        }
    
        //Paso 4. mostrar el contenido de la matriz en consola
        System.out.println("Elementos de la matriz numeros: ");
        for (i = 0; i < DIMF; i++) {
            for (j = 0; j < DIMC; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
        for (i = 0; i < DIMC; i++){
            suma = suma + m[1][i];
        }
        System.out.println("La suma de los elementos de la fila 1 es: " + suma);

        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.
        
        /*for (i = 0; i < DIMF; i++){
            for (j = 0; j < DIMC; j++){
                v[i] = v[i] + m[i][j];
            }
        }*/
        for(i=0; i<DIMF; i++){
            for (j=0; j<DIMC; j++){
                v[i] = v[i] + m[i][j];
            }
        }
       
        for (i = 0; i < DIMF; i++){
            System.out.print(v[i] + "|");
        }
        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".
        
        System.out.println();
        aux = Lector.leerInt();
        j = 0;
        i = 0;
        while ((i < DIMF) && (!encontre)){
            while ((j < DIMC) && (!encontre)){
                if (m[i][j] == aux){
                    encontre = true;
                    indiceI = i;
                    indiceJ = j;
                }
                j++;
            }
            j =0;
            i++;
        }
        if (encontre != false){
            System.out.println("El elemento se encuentra en la posicion " + indiceI + " " + indiceJ);
        }
        else{
            System.out.println("No se encontró el elemento");
        }
    }
}
