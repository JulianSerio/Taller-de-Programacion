/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema5.ej01;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Ej01Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Proyecto p = new Proyecto("Netflix","Juan Carlos",20);
        
        int categoria;
        String nombre,especialidad,motivo;
        double monto;
        String cargo;
        
        
        for (int i = 0; i < 3; i++){
            categoria = GeneradorAleatorio.generarInt(5) + 1;
            System.out.print("Ingrese nombre investigador: ");
            nombre = Lector.leerString();
            especialidad = GeneradorAleatorio.generarString(10);
            
            System.out.println("Nombre: " + nombre + " Categoria: " + categoria + " Especialidad: " + especialidad);
            
            Investigador in = new Investigador(nombre,categoria,especialidad);
    
            p.agregarInvestigador(in);
            
            for (int j = 0; j < 2; j++){
                monto = GeneradorAleatorio.generarDouble(5000);
                motivo = GeneradorAleatorio.generarString(15);
                
                System.out.println("Monto: " + monto + " Motivo: " + motivo);
                
                Subsidio s = new Subsidio(monto,motivo);
                in.agregarSubsidio(s);
            }
            System.out.print("Otorgo prestamos? ");
            cargo = Lector.leerString();
            if (cargo.equals("SI")){
                in.otorgarTodos(nombre);
            }
        }
         
        System.out.println(p.toString());
        
    }
    
}
