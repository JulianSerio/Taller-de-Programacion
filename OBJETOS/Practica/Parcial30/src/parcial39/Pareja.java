/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial39;

/**
 *
 * @author Julian
 */
public class Pareja {
    private Participante participante1;
    private Participante participante2;
    private String estilo;

    public Pareja(Participante participante1, Participante participante2, String estilo) {
        this.participante1 = participante1;
        this.participante2 = participante2;
        this.estilo = estilo;
    }
    
    public int diferenciaEdad(){
        int aux = participante1.getEdad() - participante2.getEdad();
        if (aux < 0){
            aux = participante2.getEdad() - participante1.getEdad();
        }
        return aux;
    }

    public Participante getParticipante1() {
        return participante1;
    }

    public void setParticipante1(Participante participante1) {
        this.participante1 = participante1;
    }

    public Participante getParticipante2() {
        return participante2;
    }

    public void setParticipante2(Participante participante2) {
        this.participante2 = participante2;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return "Pareja{" + "participante1=" + participante1 + ", participante2=" + participante2 + '}';
    }
    
    
    
    
    
}
