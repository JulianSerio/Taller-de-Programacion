/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial3;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Parcial3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        Sistema s = new Sistema();
        
        String nombre;
        double costo;
        boolean obraSocial;
        int x,y;
        
        for (int i = 0; i < 5; i++){
            nombre = GeneradorAleatorio.generarString(10);
            costo = GeneradorAleatorio.generarDouble(2000);
            obraSocial = GeneradorAleatorio.generarBoolean();
            
            Paciente p = new Paciente(nombre,obraSocial,costo);
            
            System.out.println(p);
            
            System.out.print("Ingrese X: ");
            x = Lector.leerInt();
            System.out.print("Ingrese Y: ");
            y = Lector.leerInt();
            s.agendarPaciente(p, x, y);  
        }
        System.out.println(s);
        System.out.println();
        System.out.print("Ingrese DIA a Liberar Turnos: ");
        x = Lector.leerInt();
        System.out.println("Contactarse con: " + s.liberarTurnos(x));
        System.out.println();
        System.out.println(s.calcularCosto());
        System.out.println();
        System.out.println(s);
        

    }
    
}
