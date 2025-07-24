/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial9;

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
    }
    
    public void almacenarLibro(Libro l, int E){
        int j =0;
        while (m[E][j] != null){
            j++;
        }
        m[E][j] = l;
    }
    
    public Libro sacarLibro(int X, int Y){
        Libro li = null;
        if (m[X][Y] != null){
            li = m[X][Y];
            m[X][Y] = null;
        }
        return li;
    }
    
    public int calcular(){
        double peso = 0;
        double max = -1;
        int estante = -1;
        int i;
        for (i = 0; i < N; i++){
            peso = 0;
            for (int j = 0; j < M; j++){
                if (m[i][j] != null){
                  peso = peso + m[i][j].getPeso();    
                }
            }
            if (peso > max){
                max = peso;
                estante = i;
            }
        }
        return estante;
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
                    aux = aux + "Estante " + i + " Libro " + j + " " + m[i][j] + '\n';
                }
                else{
                    aux = aux + "Estante " + i + " Libro " + j + " VACIO" + '\n';
                }
            }
        }
        return aux;
    }
    
    
    
    
    
   
    
}
