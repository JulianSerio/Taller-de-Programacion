/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial46;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Julian
 */
public class Fecha {
    private int N;
    private int M;
    private int [] v;
    private Alumno [][] m;

    public Fecha(int N, int M) {
        this.N = N;
        this.M = M;
        v = new int [N];
        m = new Alumno[N][M];
    }
    
    private void inicializo(){
        int i;
        for (i = 0; i < N; i++);{
            v[i]=0;
        }
    }
    
    public void agregarAlumno(Alumno a, int X){
        m[X][v[X]] = a;
        v[X]++;
        System.out.println("Sala: " + X + " dimL: " + v[X]);
    }
    
    public void asignarTurno(){
        GeneradorAleatorio.iniciar();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < v[i]; j++){
                if (m[i][j] != null){
                    m[i][j].setTema(GeneradorAleatorio.generarInt(M) + 1);
                }
            }
        }
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
            for (int j = 0; j < v[i]; j++){
                if (m[i][j] != null){
                    aux = aux + m[i][j] + '\n';
                }
            }
        }
        return aux;
    }

    
    
    
    
    
}
