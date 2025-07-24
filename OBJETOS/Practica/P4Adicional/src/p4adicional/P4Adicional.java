/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4adicional;

/**
 *
 * @author Julian
 */
import PaqueteLectura.Lector;
public class P4Adicional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zona z1 = new Zona("El Mondongo","La Plata","Buenos Aires");
        Zona z2 = new Zona("Villa Elvira","La Plata","Buenos Aires");
        Electoral e = new Electoral(5,203,z1);
        Referendum r = new Referendum(204,z2);
        
        int dni,N,M;
        System.out.println("Ingrese Dni: ");
        dni = Lector.leerInt(); 
        
        while (dni != 0){
            System.out.println("Ingrese N: ");
            N = Lector.leerInt();
            if (e.validarNumeroDeLista(N)){
                e.votarPorLista(N);
            }
            else{
                e.votarEnBlanco();
            }
            
            
            System.out.println("Ingrese M: ");
            M = Lector.leerInt();
            if (M > 0){
                r.votarAFavor();
            }
            else{
                if (M == 0){
                    r.votarEnBlanco();
                }
                else{
                    r.votarEnContra();
                }
                
            }
            
            
            System.out.println("Ingrese Dni: ");
            dni = Lector.leerInt();
        }
        
        System.out.println(e);
        System.out.println();
        System.out.println(r);
    }
    
}
