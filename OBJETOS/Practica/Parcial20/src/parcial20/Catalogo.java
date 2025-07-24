/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial20;

/**
 *
 * @author Julian
 */
public class Catalogo {
    private int dimL = 0;
    private int DIMF = 15;
    private Artista []v = new Artista[DIMF];

    public Catalogo() {
    }
    
    public void agregarArtista(Artista a){
        v[dimL] = a;
        dimL++;
    }

    public int getDimL() {
        return dimL;
    }

    public int getDIMF() {
        return DIMF;
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < dimL; i++){
            aux = aux + v[i].getNombre() + " " + (i+1) + ", " + v[i].getObra() + '\n';        }
        return aux;
    }
    
    
    
    
}
