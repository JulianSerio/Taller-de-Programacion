/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema5.ej01;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Julian
 */
public class Investigador {
    private String nombreCompleto;
    private int categoria;
    private String especialidad;
    private int DIMF = 5;
    private int dimL = 0;
    private Subsidio [] v = new Subsidio[DIMF];

    public Investigador(String nombreCompleto, int categoria, String especialidad) {
        this.nombreCompleto = nombreCompleto;
        this.categoria = categoria;
        this.especialidad = especialidad;
    }    
    
    public void agregarSubsidio(Subsidio s){
        if (dimL < DIMF){
            v[dimL] = s;
            dimL++;
        }
    }
    
    public double dineroTotalOtorgado(){
        double aux = 0;
        for (int i = 0; i < dimL; i++){
            if (v[i].isOtorgado())
                aux = aux + v[i].getMonto();
        }
        return aux;
    }
    
    public void otorgarTodos (String nombre){
        if (nombreCompleto.equals(nombre)){
            for (int i = 0; i < dimL; i++){
                if(!v[i].isOtorgado()){
                    v[i].setOtorgado(true);
                }
            }
        }
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getDimL() {
        return dimL;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }

    public int getDIMF() {
        return DIMF;
    }

    @Override
    public String toString() {
        return "Investigador{" + "nombreCompleto=" + nombreCompleto + ", categoria=" + categoria + ", especialidad=" + especialidad +  ", dinero total=" + this.dineroTotalOtorgado()  + '}';
    }
}
