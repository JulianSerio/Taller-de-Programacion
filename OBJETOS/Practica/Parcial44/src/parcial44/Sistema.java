/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial44;

/**
 *
 * @author Julian
 */
public class Sistema {
    private int DIAS = 5;
    private int TURNOS = 6;
    private Paciente [][]m = new Paciente[DIAS][TURNOS];

    public Sistema() {
    }
    
    public void agregarPaciente(int D, int T, Paciente P){
        m[D][T] = P;
    }
    
    public void liberarTurnos(String nombre){
        for (int i = 0; i < DIAS; i++){
            for (int j = 0; j < TURNOS; j++){
                if (m[i][j] != null){
                    if (m[i][j].getNombre().equals(nombre)){
                        m[i][j] = null;
                    }
                }
            }
        }
    }
    
    public boolean agendado(String nombre, int D){
        boolean esta = false;
        int j = 0;
        while ((j < TURNOS)&&(!esta)){
            if (m[D][j] != null){
                if (m[D][j].getNombre().equals(nombre)){
                    esta = true;
                }
            }
            j++;
        }
        return esta;
    }

    public int getDIAS() {
        return DIAS;
    }

    public int getTURNOS() {
        return TURNOS;
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < DIAS; i++){
            for (int j = 0; j < TURNOS; j++){
                if (m[i][j] != null){
                    aux = aux + "DIA " + i + " " + " TURNO " + j + " " + m[i][j] + '\n'; 
                }
                else{
                   aux = aux + "DIA " + i + " " + " TURNO " + j + " " + " LIBRE " + '\n'; 
                }
            }
        }
        return aux;
    }
    
    
    
    
}
