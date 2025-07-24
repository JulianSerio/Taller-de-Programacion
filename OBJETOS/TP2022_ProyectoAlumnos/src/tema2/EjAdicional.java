/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class EjAdicional {

/*1- a) Cargue la clase Auto.java (dada por la cátedra) en su proyecto. 
Un objeto auto se crea sin valores iniciales y responde a los siguientes mensajes: 
getPatente() retorna la patente (int) del auto
getDueño() retorna el nombre del dueño (String) del auto
setPatente(X) modifica el número de patente al “int” pasado por parámetro (X)
setDueño(X) modifica el nombre del dueño al “String” pasado por parámetro (X)
toString() retorna un String que representa al objeto. Ej: “Patente 111222 Dueño Carla 
Perez”

b) Simular la entrada de autos al estacionamiento municipal en el centro de la ciudad. El 
estacionamiento está dividido en 5 pisos y cada piso tiene 10 plazas, y debemos 
almacenar en una estructura de datos adecuada los autos estacionados. 
Realice un programa que lea la información de 5 autos que desean estacionar. Por cada 
auto, también lea número de piso y número de plaza e ingréselo al estacionamiento. 
Nota: Al principio el estacionamiento debe estar vacío (sin autos). 
c) A partir de la estructura de autos, informar para cada número de piso y número de 
plaza ocupado, la representación del auto que la ocupa and open the template in the editor.
 */

    public static void main(String[] args) {
        int FILAS = 5;
        int COLUMNAS = 10;
        Auto [][]m = new Auto[FILAS][COLUMNAS];
            
        int i,patente,piso,plaza;
        String nombre;
        for (i = 0; i < 5; i++){
            nombre = GeneradorAleatorio.generarString(10);
            patente = GeneradorAleatorio.generarInt(10000);
            System.out.print("Piso 0..4: ");
            piso = Lector.leerInt();
            System.out.print("Plaza 0..9: ");
            plaza = Lector.leerInt();
            
            m[piso][plaza] = new Auto(patente,nombre);              
        }
        
        for (i = 0; i < FILAS; i++){
            for (int j = 0; j < COLUMNAS; j++){
                if (m[i][j] != null)
                    System.out.println("Piso " + i + " Plaza: " + j + " " + m[i][j].toString());
            }
        }
    }
    
}
