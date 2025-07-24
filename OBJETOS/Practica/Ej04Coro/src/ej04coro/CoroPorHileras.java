/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej04coro;

/**
 *
 * @author Julian
 */
public class CoroPorHileras extends Coro{
    private int FILAS;
    private int COLUMNAS;
    private int dimF = 0;
    private int dimC = 0;
    private Corista [][]m;

    public CoroPorHileras(int FILAS, int COLUMNAS, String nombre, Director director) {
        super(nombre, director);
        this.FILAS = FILAS;
        this.COLUMNAS = COLUMNAS;
        m = new Corista[FILAS][COLUMNAS];
    }


    @Override
    public void agregarCorista(Corista c) {
        if (dimC < COLUMNAS){
            m[dimF][dimC] = c;
            dimC++;
        }
        else{
            dimC = 0;
            dimF++;
            m[dimF][dimC] = c;
            dimC++;
        }
    }
    

    @Override
    public boolean estaLleno() {
        boolean lleno = false;
        if ((dimF == FILAS) && (dimC == COLUMNAS)){
            lleno = true;
        }
        return lleno;
    }

    @Override
    public boolean bienFormado() {
        int i = 0; 
        int j = 0;
        int act;
        boolean bien = true;
        while (i < dimF){
            while (j < dimC - 1){
                if (m[i][j].getTono() != m[i][j+1].getTono()){
                    bien = false;
                }
                j++;
            }
            i++;
 
        }
        j = 0;
        i = 0;
        
        while (i < FILAS - 1){
            if (m[i][j].getTono() < m[i + 1][j].getTono()){
                bien = false;
            }
            i++;
        }
        
        return bien;
    }

    public int getFILAS() {
        return FILAS;
    }

    public int getCOLUMNAS() {
        return COLUMNAS;
    }

    public int getDimF() {
        return dimF;
    }

    public int getDimC() {
        return dimC;
    }

    @Override
    public String toString() {
        String aux = super.toString() + '\n';
        for (int i = 0; i <= dimF; i++){
            if (i != dimF){
                for (int j = 0; j < COLUMNAS; j++){
                    aux = aux + m[i][j].toString() + '\n';
                }
            }
            else{
                for (int j = 0; j < dimC; j++){
                    aux = aux + m[i][j].toString() + '\n'; 
                }
            }
        }
        return aux;
    }
      
}
