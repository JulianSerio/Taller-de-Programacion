/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej01proyecto;

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
        Proyecto p = new Proyecto("Giros",5,"Fito Paez");
        
        String nombre,especialidad,motivo,otorgar;
        int categoria;
        double monto;
        
        for (int i = 0; i < 3; i++){
            nombre = GeneradorAleatorio.generarString(10);
            especialidad = GeneradorAleatorio.generarString(8);
            categoria = GeneradorAleatorio.generarInt(5) + 1;
            
            System.out.println("Nombre: "+ nombre + " Especialidad: "+ especialidad + " Categoria: " + categoria);
            
            Investigador inv = new Investigador(nombre,categoria,especialidad);
            
            p.agregarInvestigador(inv);
            
            for (int j = 0; j < 2; j++){
                motivo = GeneradorAleatorio.generarString(10);
                monto = GeneradorAleatorio.generarDouble(2000);
                
                System.out.println("Monto: " + monto + " Motivo: " + motivo);
                
                Subsidio s = new Subsidio(monto,motivo);
                
                inv.agregarSubsidio(s);
                
            }
            System.out.println("Desea otorgar subsidios?: ");
            otorgar = Lector.leerString();
            if (otorgar.equals("Si")){
                inv.otorgarTodos();
            }
            
        }
        
        System.out.println(p.toString());
    }
    
}
