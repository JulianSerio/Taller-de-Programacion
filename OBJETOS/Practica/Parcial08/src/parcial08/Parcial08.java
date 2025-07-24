/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial08;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Parcial08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LibroElectronico LE = new LibroElectronico(".pdf",8,"Mujercitas",300);
        LibroFisico LF = new LibroFisico(true,"Mi Lucha",300);
        
        String nombre;
        
        for (int i = 0; i < 3; i++){
            nombre = GeneradorAleatorio.generarString(10);            
            LE.agregarAutor(nombre);
        }
        for (int i = 0; i < 3; i++){
            nombre = GeneradorAleatorio.generarString(10);            
            LF.agregarAutor(nombre);
        }
        System.out.println(LE);
        System.out.println();
        System.out.println(LF);
                
    }
    
}
