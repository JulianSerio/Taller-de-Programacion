/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial12;

/**
 *
 * @author Julian
 */
public class Sistema {
    private int DIAS = 5;
    private int TURNOS = 6;
    private Paciente [][]m = new Paciente[DIAS][TURNOS];

    public Sistema() {
        //inicializarMatriz();
    }
    
    public int agendarPaciente(Paciente P,int D){
        int j = 0;
        while(m[D][j] != null){
            j++;
        }
        m[D][j] = P;
        return j;
    } 
    

    
    public String liberarTurnos (int T){
        String aux = "";
        for (int i = 0; i < DIAS; i++){
            if (m[i][T] != null){
                aux = aux + " Nombre Paciente: " + m[i][T].getNombre() + '\n';
                m[i][T] = null;
            }
        }
        return aux;
    }   
    
    public int diaMasPacientes (){
        int pacientes,diaMas = -1;
        int max = -1;
        for (int i = 0; i < DIAS; i++){
            pacientes = 0;
            for (int j = 0; j < TURNOS; j++){
                if (m[i][j] != null){
                    pacientes++;
                }
            }
            if (pacientes > max){
                max = pacientes;
                diaMas = i;
            }
        }
        return diaMas;
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
                    aux = aux + "Dia: " + i + " Turno: " + j + " " + m[i][j] + '\n';
                }
                else{
                    aux = aux + "Dia: " + i + " Turno: " + j + " " + "Libre" + '\n';
                }
            }
        }
        return aux;
    }
    
    
    
    
    
}
