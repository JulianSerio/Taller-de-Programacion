/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adicionales;

/**
 *
 * @author PC
 */
public class Por_hileras extends Coro{
    private Corista [][] coristas;
    private int filas, columnas, DimF=0, DimC=0;

    public Por_hileras(int filas, int columnas, String nombreC, Director dir) {
        super(nombreC, dir);
        this.filas = filas;
        this.columnas = columnas;
        coristas = new Corista[filas][columnas];
    }
    
    public void agregarCorista(Corista c){
        if(DimF < filas){
            coristas[DimF][DimC]=c;
            DimF++;
        }
        else{
            DimF=0;
            DimC++;
            coristas[DimF][DimC]=c;
            DimF++;
        }
    }
    
    public boolean coroLleno(){
        boolean aux=true;
        
        if(DimC < columnas){
            if(DimF < filas){
                aux=false;
            }
        }
        return aux;
    }
    
    public boolean bienOrdenado(){
        boolean aux=true;
        int f=0, c=0;
        
        while((c<columnas)&&(aux)){
            while((f<filas-1)&&(aux)){
                if(coristas[f][c].getTono()!=coristas[f+1][c].getTono()){
                    aux=false;
                }
                f++;
            }
            c++;
        }
        
        c=0;
        f=0;
        
        while((c<columnas-1)&&(aux)){
            if(coristas[f][c].getTono()>coristas[f][c+1].getTono()){
                aux=false;
            }
            c++;
        }
        
        return aux;
    }

    @Override
    public String toString() {
        String auxS=super.toString();
        String aux="";
        
        for(int i=0; i<=DimC;i++){
            if(i!=DimC){
                for(int j=0; j<filas;j++){
                    aux=aux + coristas[j][i] + '\n';
                }
            }
            else{
                for(int f=0; f<DimF;f++){
                    aux=aux + coristas[f][i] + '\n';
                }
            }
            
        }
        
        auxS=auxS + aux;
        
        return auxS;
    }
    
    
}
