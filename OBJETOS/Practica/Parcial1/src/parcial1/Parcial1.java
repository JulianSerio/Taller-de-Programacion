/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

/**
 *
 * @author Julian
 */
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;
public class Parcial1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema s = new Sistema();
        int D,T;
        String nombre;
        Boolean obraSocial;
        double costo;
        
        for (int i = 0; i < 1; i++){
            System.out.print("Ingresa nombre: ");
            nombre = Lector.leerString();
            obraSocial = GeneradorAleatorio.generarBoolean();
            costo = GeneradorAleatorio.generarDouble(3000) + 1;
            
            Paciente p = new Paciente(nombre,obraSocial,costo);
            
            System.out.println("Nombre: " + nombre + " Obra social: " + obraSocial + " Costo: " + costo);
            
            System.out.print("Ingrese Dia (0..4): ");
            D = Lector.leerInt();
            System.out.print("Ingrese Turno (0..5): ");
            T = Lector.leerInt();
            
            s.agendarPaciente(p, D, T);
        }
        System.out.println(s.toString());
        
        
        System.out.print("Ingresa nombre: ");
        nombre = Lector.leerString();
        s.liberarTurnos(nombre);
        
        System.out.print("Ingrese Dia (0..4): ");
        D = Lector.leerInt();
        System.out.print("Ingresa nombre: ");
        nombre = Lector.leerString();
        System.out.println(s.estaAgendado(D, nombre));
        
        
        System.out.println(s.toString());
        
        

    }
    
}
