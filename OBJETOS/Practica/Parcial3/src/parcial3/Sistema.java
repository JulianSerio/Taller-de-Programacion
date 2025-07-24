/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial3;

/**
 *
 * @author Julian
 */
public class Sistema {
    private int DIAS = 5;
    private int TURNOS = 6;
    private Paciente [][] m = new Paciente[DIAS][TURNOS];

    public Sistema() {
        //inicializoMatrizNull;
    }
    
    public void agendarPaciente(Paciente P, int D, int T){
        m[D][T] = P;
    }
    
    public String liberarTurnos(int D){
        String aux = "";
        for (int j = 0; j < TURNOS; j++){
            if (m[D][j] != null){
                aux = aux + m[D][j].getNombre() + '\n';
                m[D][j] = null;
            }
        }
        return aux;
    }
    
    public double calcularCosto(){
        double aux = 0;
        for (int i = 0; i < DIAS; i++){
            for (int j = 0; j < TURNOS; j++){
                if (m[i][j] != null){
                    aux = aux + m[i][j].getCosto();
                }
            }
        }
        return aux;
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
                    aux = aux + "Dia: " + i + " Turno: " + j + m[i][j] + '\n';
                }
                else{
                    aux = aux + "Dia: " + i + " Turno: " + j + " Libre" + '\n';
                }
            } 
        }
        return aux;
    }
    
    
    
}
