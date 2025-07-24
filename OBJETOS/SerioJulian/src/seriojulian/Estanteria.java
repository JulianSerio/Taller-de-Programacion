/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seriojulian;

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
        //inicializoMatriz();
    }
    
    public void almacenarLibro(Libro l){
        int i = 0;
        int j = 0;
        boolean encontre = false;
        
        while (!encontre){
            j = 0;
            while ((j < M)&&(!encontre)){
                if (m[i][j] == null){
                    m[i][j] = l;
                    encontre = true;
                }
                j++;
            }
            i++;
        }
    }

    public Libro sacarLibro(int x, int y){
        Libro l = null;
        l = m[x][y];
        m[x][y] = null;
        return l;
    }
    
    public int calcular(String autor){
        int cant = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (m[i][j] != null){
                    if (m[i][j].getAutor().equals(autor)){
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
                    aux = aux + "Estante: " + i + " Lugar: " + j + " " + m[i][j] + '\n';
                }
                else{
                    aux = aux + "Estante: " + i + " Lugar: " + j + " " + "Libre" + '\n';
                }
            }
        }    
        return aux;
    }
   
}
