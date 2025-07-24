/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej03recitales;

/**
 *
 * @author Julian
 */
public class EventoOcacional extends Recital{
    private String motivo;
    private String contratante;
    private int dia;

    public EventoOcacional(String motivo, String contratante, int dia, String banda, int DIMF) {
        super(banda, DIMF);
        this.motivo = motivo;
        this.contratante = contratante;
        this.dia = dia;
    }
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getContratante() {
        return contratante;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String actuar() {
        String aux = "";
        if (this.getMotivo().equals("Show benefico")){
            aux = "Recuerden colaborar con..." + this.getContratante();
        }
        else {
            if (this.getMotivo().equals("Show TV")){
                aux = "Saludos amigos televidentes ";
            }
            else{
                aux = "Un feliz cumpleanos para..." + this.getContratante();
            }
        }
        return aux + '\n' + super.toString();
    }

    @Override
    public double calcularCosto() {
        if (this.getMotivo().equals("Show benefico")){
            return 0;
        }
        else {
            if (this.getMotivo().equals("Show TV")){
                return 50000;
            }
            else{
                return 150000;
            }
        }
    }  
}
