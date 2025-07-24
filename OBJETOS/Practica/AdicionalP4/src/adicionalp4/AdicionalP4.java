/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adicionalp4;

import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class AdicionalP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Zona z = new Zona("Villa Elvira","La Plata","Buenos Aires");
        
        UrnaElectoral uE = new UrnaElectoral(5,203,z);
        UrnaReferendum uR = new UrnaReferendum(204,z);
        
        int N,DNI,M;
        System.out.println("Ingrese DNI: ");
        DNI = Lector.leerInt();
        while (DNI != 0){
            System.out.println("Ingrese numero de lista(N): ");
            N = Lector.leerInt();
            if (uE.validarNumeroLista(N)){
                System.out.println("VALIDADO!");
                uE.votarLista(N);
            }
            else{
                uE.votarEnBlanco();
            }
            
            System.out.println("Ingrese numero de lista(M): ");
            M = Lector.leerInt();
            if (M == 0){
                uR.votarEnBlanco();
            }
            else{
                if (M > 0){
                    uR.votarAFavor();
                }
                else{
                    uR.votarEnContra();
                }
            }
            
            System.out.println("Ingrese DNI: ");
            DNI = Lector.leerInt();
        }
        System.out.println(uE);
        System.out.println(uR);
    }  
}
