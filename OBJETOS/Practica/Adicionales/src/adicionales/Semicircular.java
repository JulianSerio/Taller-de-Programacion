/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adicionales;

/**
 *
 * @author PC
 */
public class Semicircular extends Coro{
    private Corista [] coristas;
    private int DimF;
    private int DimL=0;

    public Semicircular(String nombreC, Director dir, int DimF) {
        super(nombreC, dir);
        this.DimF=DimF;
        
        coristas= new Corista[DimF];
    }
    
    public void agregarCorista(Corista c){
        if(DimL < DimF){
            coristas[DimL]=c;
            DimL++;
        }
    }
    
    public boolean coroLleno(){
        boolean aux=true;
        if(DimL < DimF){
            aux=false;
        }
        return aux;
    }
    
    public boolean bienOrdenado(){
        boolean aux=true;
        int i=0;
        
        while ((i<DimF-1)&&(aux)){
            if(coristas[i].getTono() < coristas[i+1].getTono()){
                aux=false;
            }
            i++;
        }
        return aux;
    }

    @Override
    public String toString() {
        String auxS=super.toString();
        String aux="";
        
        for(int i=0; i<DimL; i++){
            aux=aux + coristas[i] + '\n';
        }
        auxS= auxS + aux;
        
        return auxS;
    }
    
}
