
package tema1;

//Paso 1: Importar la funcionalidad para lectura de datos
import PaqueteLectura.Lector;

public class Ej02Jugadores {

  
    public static void main(String[] args) {
        //Paso 2: Declarar la variable vector de double 
        //Paso 3: Crear el vector para 15 double 
        int DIMF = 10;
        double [] vector = new double [DIMF];
        
        //Paso 4: Declarar indice y variables auxiliares a usar
        int i;
        int cant = 0;
        double suma = 0;
        double prom;
                
        //Paso 6: Ingresar 15 numeros (altura), cargarlos en el vector, ir calculando la suma de alturas
        for (i = 0; i < DIMF; i++){
            System.out.println("Ingrese altura del jugador " + (i+1) + " : ");
            vector[i] = Lector.leerDouble();
        }
        
        for (i = 0; i < DIMF; i++){
            System.out.println(vector[i]);
        }
        
        //Paso 7: Calcular el promedio de alturas, informarlo
        for (i = 0; i < DIMF; i++){
            suma = suma + vector[i];
        }
        prom = suma / DIMF;
        System.out.println("El promedio de alturas es: " + prom);
        
        //Paso 8: Recorrer el vector calculando lo pedido (cant. alturas que están por encima del promedio)
        for (i = 0; i < DIMF; i++){
            if (vector[i] > prom){
                cant = cant + 1;
            }
        }
   
        //Paso 9: Informar la cantidad.
        System.out.println("La cantidad de jugadores por encima del promedio es: " + cant);
    }
    
}
