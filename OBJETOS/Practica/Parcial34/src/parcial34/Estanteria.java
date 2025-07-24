/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial34;

/**
 *
 * @author Julian
 */
public class Estanteria {
    private int N;
    private int M;
    private Libro [][]m;

    public Estanteria(int N, int M) {
        this.N = N;
        this.M = M;
        m = new Libro[N][M];
        //inicializo matriz en null;
    }
    
    public void almacenarLibro(Libro L){
        int i = 0;
        int j;
        boolean encontre = false;
        while (!encontre){
            j = 0;
            while ((j < M) && (!encontre)){
                if (m[i][j] == null){
                    m[i][j] = L;
                    encontre = true;
                }
                j++;
            }
            i++;
        }
    }
    
    public Libro sacarLibro (int X, int Y){
        Libro aux = null;
        aux = m[X][Y];
        m[X][Y] = null;
        return aux;
    }
    
    public int calcular(String nombre){
        int cant = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (m[i][j] != null){
                    if (m[i][j].getNombreAutor().equals(nombre)){
                        cant++;
                    }
                }
            }
        }
        return cant;   
    }

    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (m[i][j] != null){
                    aux = aux + "Estante " + i + " Lugar " + j + " " + m[i][j] + '\n';
                }
                else{
                    aux = aux + "Estante " + i + " Lugar " + j + " Libre" + '\n';
                }
            }
        }
        return aux;
    }
    
    
    
    
}
