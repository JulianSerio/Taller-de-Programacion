/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial41_2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Parcial41_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Discografica d = new Discografica("Milanga Records","La Plata");
        
        String nombre, ciudad, instrumento;
        int integrantes, temas;
        
        System.out.print("Ingrese temas: ");
        temas = Lector.leerInt();
        while (temas != 0){
            nombre = GeneradorAleatorio.generarString(10);
            instrumento = GeneradorAleatorio.generarString(10);
            
            //System.out.println("Instrumento: ");
           // instrumento = Lector.leerString();
            
            System.out.println("Nombre: " + nombre + " Instrumento: " + instrumento + " Temas: " + temas);
            
            Solista s = new Solista(nombre,instrumento,temas);
            
            d.agregarSolista(s);
            
            System.out.print("Ingrese temas: ");
            temas = Lector.leerInt();
        }
        
        System.out.print("Ingrese cant integrantes: ");
        integrantes = Lector.leerInt();
        while (integrantes != 0){
            nombre = GeneradorAleatorio.generarString(10);
            //ciudad = GeneradorAleatorio.generarString(10);
            
            System.out.println("Ciudad: ");
            ciudad = Lector.leerString();
            
            System.out.println("Nombre: " + nombre + " Ciudad: " + ciudad + " Integrantes: " + integrantes);
            
            Banda b = new Banda(nombre,ciudad,integrantes);
            
            d.agregarBanda(b);
            System.out.print("Ingrese cant integrantes: ");
            integrantes = Lector.leerInt();
        }
        
        //System.out.println("Cantidad de bandas: "+d.cantBandas());
        
        System.out.println("Instrumento: ");
        instrumento = Lector.leerString();
        System.out.println(d.cantSolistasMismoInstrumento(instrumento));
        System.out.println("Banda con mas integrantes: "+d.bandaMasIntegrantes());
        System.out.println("Bandas de la misma ciudad: "+d.cantBandasMismaCiudad());
    }
   
}
