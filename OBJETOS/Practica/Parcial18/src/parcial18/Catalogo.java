/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial18;

/**
 *
 * @author Julian
 */
public class Catalogo {
    private int DIMF = 15;
    private Artista []v = new Artista[DIMF];

    public Catalogo() {
    }
    
    public void agregarArtista(Artista A, int C){
        if (v[C] == null){
            v[C] = A;
        }
    }

    public int getDIMF() {
        return DIMF;
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < DIMF; i++){
            if (v[i] != null){
                aux = aux + "Categoria " + (i + 1) + " " + v[i].toString() + '\n';
            }
            else{
                aux = aux + "Categoria " + (i + 1) + " Sin Artista" + '\n';
            }
        }
        return aux;
    }
    
    
    
}
