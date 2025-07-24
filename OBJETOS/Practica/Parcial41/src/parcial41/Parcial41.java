/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial41;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Parcial41 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre, ciudadRes, dueno, instrumento;
        int integrantes, temas;
        
        
        System.out.print("Nombre: ");
        nombre = Lector.leerString();
        System.out.print("Ciudad: ");
        ciudadRes = Lector.leerString();
        System.out.print("Dueno: ");
        dueno = Lector.leerString();
        Discografica d = new Discografica(dueno,nombre,ciudadRes);
        
        System.out.println("----CARGA SOLISTAS----");
        
        System.out.print("Temas: ");
        temas = Lector.leerInt();
        
        while (temas != 0){
            nombre = GeneradorAleatorio.generarString(10);
            System.out.print("Instrumento: ");
            instrumento = Lector.leerString();
            
            System.out.println("Nombre: " + nombre + " Instrumento: " + instrumento + " Temas: " + temas);

            Solista s = new Solista(nombre,instrumento,temas);
            d.agregarSolista(s);
            
            System.out.print("Temas: ");
            temas = Lector.leerInt();
        }
        
        System.out.println("----CARGA BANDAS----");
        
        System.out.print("Integrantes: ");
        integrantes = Lector.leerInt();
        
        while (integrantes != 0){
            nombre = GeneradorAleatorio.generarString(10);
            System.out.print("Ciudad: ");
            ciudadRes = Lector.leerString();
            
            System.out.println("Nombre: " + nombre + " Ciudad: " + ciudadRes + " Integrantes: " + integrantes);
            
            Banda b = new Banda(nombre,ciudadRes,integrantes);
            d.agregarBanda(b);
            
            System.out.print("Integrantes: ");
            integrantes = Lector.leerInt();
        }
        
        System.out.println("Cantidad bandas representadas: " + d.cantBandasRepresentabas());
        
        System.out.println("Instrumento: ");
        instrumento = Lector.leerString();
        System.out.println("Cant: " + d.cantInstrumentos(instrumento));
        
        System.out.println("Banda con mas integrantes: " + d.bandaMasIntegrantes());
        
        System.out.println("Bandas formadas en la misma ciudad: " + d.cantBandasMismaCiudad());
        
    }
    
}
