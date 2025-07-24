/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial44;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Parcial44 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        Sistema s = new Sistema();
        
        int x,y;
        String nombre;
        boolean obraSocial;
        double costo;
        
        for (int i = 0; i < 5; i++){
            nombre = GeneradorAleatorio.generarString(10);
            obraSocial = GeneradorAleatorio.generarBoolean();
            costo = GeneradorAleatorio.generarDouble(3000);
            
            Paciente p = new Paciente(nombre,costo,obraSocial);
            
            
            System.out.println("Dia (0..4)");
            x = Lector.leerInt();
            System.out.println("Turno (0..5)");
            y = Lector.leerInt();
            
            s.agregarPaciente(x,y,p);
        }
        System.out.println(s);
        System.out.println();
        System.out.println("Nombre: ");
        nombre = Lector.leerString();
        s.liberarTurnos(nombre);
        System.out.println(s);
        System.out.println();
        
        System.out.println("Dia (0..4)");
        x = Lector.leerInt();   
        System.out.println("Nombre: ");
        nombre = Lector.leerString();
        System.out.println(s.agendado(nombre,x));
    }
    
}
