/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Julian
 */
public class Estante {
    private int DIMF = 20;
    private int dimL = 0;
    private Libro []v = new Libro[DIMF];

    public Estante() {
    }
    
    public void agregarLibro (String unTitulo,  String unaEditorial, 
    int unAnoEdicion,  Autor unPrimerAutor, String unISBN, double unPrecio){
        v[this.dimL] = new Libro (unTitulo,unaEditorial,unAnoEdicion,unPrimerAutor,unISBN,unPrecio);
        dimL++;
    }

    public int getDIMF() {
        return DIMF;
    }

    public void setDIMF(int DIMF) {
        this.DIMF = DIMF;
    }

    public int getDimL() {
        return dimL;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }

    public Libro[] getV() {
        return v;
    }

    public void setV(Libro[] v) {
        this.v = v;
    }
    
    public boolean estaLleno (){
        boolean aux = false;
        if (dimL == DIMF){
            aux = true; 
        }
        return aux;
    }
    
    public Libro buscarTitulo (String titulo){
        boolean encontre = false;
        int i = 0;
        Libro libro = null;
        while ((i < dimL) && (!encontre)){
            if (v[i].getTitulo().equals(titulo)){
                encontre = true;
                //libro = v[i].toString();
                libro = v[i];
            }
            i++;
        }
        return libro;
    }
    
    public void imprimirVector (){
        for (int i = 0; i < dimL; i++){
            System.out.println(v[i]);
        }
    }
     
}
