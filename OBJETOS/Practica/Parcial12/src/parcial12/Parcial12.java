/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial12;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Parcial12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema s = new Sistema();
        
        String nombre;
        boolean obraSocial;
        double costo;
        int D,T;
        
        for (int i = 0; i < 5; i++){
            nombre = GeneradorAleatorio.generarString(10);
            obraSocial = GeneradorAleatorio.generarBoolean();
            costo = GeneradorAleatorio.generarDouble(3000) + 1;
            
            System.out.println("Nombre: " + nombre + " Obra Socia: " + obraSocial + " Costo: " + costo);
            
            Paciente p = new Paciente(nombre,obraSocial,costo);
            
            System.out.println("Ingrese dia (0..4):");
            D = Lector.leerInt();
            System.out.println(s.agendarPaciente(p, D));
            
        
        }
        System.out.println(s);
        System.out.println();
        System.out.println("Liberar turno: ");
        T = Lector.leerInt();
        System.out.println("Pacientes para notificar: " + s.liberarTurnos(T));
        System.out.println(s);
        System.out.println();
        System.out.println("Dia con mas pacientes: " + s.diaMasPacientes());
    }
    
}
