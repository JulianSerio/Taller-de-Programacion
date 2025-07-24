/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial17;

/**
 *
 * @author Julian
 */
public class Catalogo {
    private int DIMF = 15;
    private int dimL = 0;
    private Artista []v = new Artista[DIMF];

    public Catalogo() {
    }

    public int getDIMF() {
        return DIMF;
    }

    public int getDimL() {
        return dimL;
    }
    
    public void agregarArtista(Artista a){
        v[dimL] = a;
        dimL++;
    }
    
    public int cantArtistas (String categoria){
        int cant =0;
        for (int i = 0; i < dimL; i++){
            if(v[i].getCategoria().equals(categoria)){
                cant++;
            }
        }
        return cant;
    }
    
    
}
