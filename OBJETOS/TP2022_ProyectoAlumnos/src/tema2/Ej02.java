/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

import tema4.Persona;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Ej02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int DIMF = 15;
        int dimL = 0, cant = 0, min = 9999;
        int edad,dni,i;
        String nombre, str = null;
        Persona []v = new Persona[DIMF]; //RESERVO ESPACIO PARA 15
        
        System.out.println("EDAD: ");
        edad = Lector.leerInt();
        while ((dimL < DIMF) && (edad != 0)){
            System.out.println("DNI: ");
            dni = Lector.leerInt();
            System.out.println("NOMBRE: ");
            nombre = Lector.leerString();
            
            Persona p = new Persona(nombre,dni,edad); //INSTANCIO PERSONA 
            v[dimL] = p; //ASIGNO AL VECTOR
            dimL++;
            System.out.println(dimL);
            
            System.out.println("EDAD: ");
            edad = Lector.leerInt();
        }
        
        for (i = 0; i < dimL; i++){
            System.out.println("---- Persona " + (i + 1)+ " -------");
            System.out.println(v[i].toString());
        }
        
        for (i = 0; i < dimL; i++){
            if (v[i].getEdad() > 65){
                cant++;
            }
            if (v[i].getDNI() < min){
                min = v[i].getDNI();
                str = v[i].toString();
            }
        }
        System.out.println("La cantidad de personas mayores a 65 son: " + cant);
        System.out.println("La persona con menor DNI es: " + str);
        
        
        
        
        

    }
    
}
