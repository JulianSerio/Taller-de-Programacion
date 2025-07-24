/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej03;

/**
 *
 * @author Julian
 */
public class EventoOcasional extends Recital{
    private String motivo;
    private String contratante;
    private int dia;

    public EventoOcasional(String motivo, String contratante, int dia, String banda, int DIMF) {
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
        if (motivo.equals("Beneficencia")){
            aux = "Recuerden colaborar con..." + this.contratante;
        }
        else{
            if (motivo.equals("TV")){
                aux = "Saludos amigos televidentes";
            }
            else{
                aux = "Un feliz cumpleanos para..." + this.getContratante();
            }
        }
        return aux + super.actuar();
    }

    @Override
    public double calcularCosto() {
        if (motivo.equals("Beneficencia")){
            return 0;
        }
        else{
            if (motivo.equals("TV")){
                return 50000;
            }
            else{
                return 150000;
            }
        }    
    }
    
}
