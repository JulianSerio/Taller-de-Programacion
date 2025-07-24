/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial37;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Julian
 */
public class Parcial37 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Electronico e = new Electronico(".pdf",50,"Mujercitas",2000);
        Fisico f = new Fisico(true,"Mi Lucha",2000);
        
        int i;
        String autor;
        
        for (i = 0; i < 3; i++){
            autor = GeneradorAleatorio.generarString(10);
            System.out.println("Autor: " + autor );
            e.agregarAutor(autor);
        }
        System.out.println();
        for (i = 0; i < 3; i++){
            autor = GeneradorAleatorio.generarString(10);
            System.out.println("Autor: " + autor );
            f.agregarAutor(autor);
        }
        
        System.out.println(e);
        System.out.println();
        System.out.println(f);
    }
    
}
