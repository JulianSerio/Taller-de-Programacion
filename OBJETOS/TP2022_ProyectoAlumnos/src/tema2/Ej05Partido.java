/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

import PaqueteLectura.Lector;

/**
 *
 * @author Julian
 */
public class Ej05Partido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int dimL = 0;
        int DIMF = 20;
        String visitante,local;
        int golesLocal,golesVisitante,i;
        int cantRiver = 0, golesBoca = 0;
        
        Partido []v = new Partido[DIMF];
                    
        System.out.println("EQUIPO VISITANTE: ");
        visitante = Lector.leerString();
        while (!"ZZZ".equals(visitante) && (dimL < DIMF)){
            System.out.println("EQUIPO LOCAL: ");
            local = Lector.leerString();
            System.out.println("GOLES VISITANTE: ");
            golesVisitante = Lector.leerInt();
            System.out.println("GOLES LOCAL: ");
            golesLocal = Lector.leerInt();
            
            v[dimL] = new Partido(local,visitante,golesLocal,golesVisitante);
            dimL++;
            
            System.out.println("EQUIPO VISITANTE: ");
            visitante = Lector.leerString();
        }
        
        for (i = 0; i < dimL; i++){
            System.out.println(v[i].getLocal() + " " + v[i].getGolesLocal() + " VS " + v[i].getVisitante() + " " + v[i].getGolesVisitante());
            if (v[i].getGanador().equals("RIVER")){
                cantRiver++;
            }
            if (v[i].getLocal().equals("BOCA")){
                golesBoca = golesBoca + v[i].getGolesLocal();
            }
        }
        
        System.out.println("Cantidad de partidos RIVER: " + cantRiver);
        System.out.println("Cantidad de goles de BOCA: " + golesBoca);

    }
    
}
