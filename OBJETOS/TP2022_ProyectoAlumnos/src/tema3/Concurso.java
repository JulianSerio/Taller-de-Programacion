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
public class Concurso {
    private int FILAS = 5;
    private int COLUMNAS;
    private Alumno [][]m;
    private int []v = new int[FILAS];

    public Concurso(int DIMF) {
        this.COLUMNAS = DIMF;
        m = new Alumno[FILAS][DIMF];
    }
    
    public void inscribirAlu(Alumno a, int genero){
        int i=0;
        while (m[genero][i] != null){
            i++;
        }
        m[genero][i] = a;
        v[genero]++;
    }

    public int getFILAS() {
        return FILAS;
    }

    public int getCOLUMNAS() {
        return COLUMNAS;
    }
    
    public Alumno maximo(){
        double max = -1;
        Alumno a = null;
        for (int i = 0; i < FILAS; i++){
            for (int j = 0; j < v[i]; j++){
                if (m[i][j].getPuntaje() > max){
                    max = m[i][j].getPuntaje();
                    a = m[i][j];
                }
            }
        }
        return a;
    }
    
    public void asignoPuntaje (int g, String nom, double p){
        for (int i = 0; i < v[g]; i++){
            if (m[g][i] != null)
                m[g][i].modificarPuntaje(p,nom);
        }   
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < FILAS; i++){
            for (int j = 0; j < v[i]; j++){
                aux = aux + "Genero " + i + " Total inscriptos: " + v[i] + " " + m[i][j] + "\n";
            }
        }
        aux = aux + "Alumno con mayor puntaje es: " + this.maximo();
        return aux;
    } 
    
}
