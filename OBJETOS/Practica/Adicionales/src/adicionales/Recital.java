/*
De todo recital se conoce el nombre de la banda y la lista de temas que tocarán durante
el recital.

- agregarTema que recibe el nombre de un tema y lo agrega a la lista de temas.

- actuar que imprime (por consola) para cada tema la leyenda “y ahora tocaremos…” seguido por el nombre del tema.

Todo recital debe saber responder al mensaje calcularCosto teniendo en cuenta lo
siguiente. Si es un evento ocasional devuelve 0 si es a beneficio, 50000 si es un show de TV
y 150000 si es privado. Las giras deben devolver 30000 por cada fecha de la misma.

 */
package Adicionales;

/**
 *
 * @author PC
 */
public abstract class Recital {
    private String nombreB;
    private String [] listaT;
    private int DimL=0;
    private int DimF;

    public Recital(String nombreB, int DimF) {
        this.nombreB = nombreB;
        this.DimF=DimF;
        listaT=new String[DimF];
    }

    public String getNombreB() {
        return nombreB;
    }

    public void setNombreB(String nombreB) {
        this.nombreB = nombreB;
    }
    
    public void agregarTema(String tema){
        if(DimL < DimF){
            listaT[DimL]=tema;
            DimL++;
        }
    }
    
    public abstract String actuar();
    public abstract double calcularCosto();
    
    public String listaTemas(){
        String aux="";
        for(int i=0; i<DimL; i++){
            aux=aux + " y ahora tocaremos: " + listaT[i] + '\n';
        }
        return aux;
    }
    
}
