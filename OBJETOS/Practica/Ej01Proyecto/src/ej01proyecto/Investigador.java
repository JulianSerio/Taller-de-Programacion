/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej01proyecto;

/**
 *
 * @author Julian
 */
public class Investigador {
    private String nombre;
    private int categoria;
    private String especialidad;
    private int DIMF = 5;
    private int dimL = 0;
    private Subsidio []v = new Subsidio[DIMF];

    public Investigador(String nombre, int categoria, String especialidad) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.especialidad = especialidad;
    }
    
    public void agregarSubsidio(Subsidio s){
        if (dimL < DIMF){
            v[dimL] = s;
            dimL++;
        }
    }
    
    public void otorgarTodos(){
        for (int i = 0; i < dimL; i++){
            if (!v[i].isOtorgado()){
                v[i].setOtorgado(true);
            }
        }
    }
    
    public double dineroTotalOtorgado(){
        double aux = 0;
        for (int i = 0; i < dimL; i++){
            if (v[i].isOtorgado()){
                aux = aux + v[i].getMonto();
            }
        }
        return aux;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getDIMF() {
        return DIMF;
    }

    public int getDimL() {
        return dimL;
    }

    @Override
    public String toString() {
        return "Investigador{" + "nombre=" + nombre + ", categoria=" + categoria + ", especialidad=" + especialidad + " total dinero: " + this.dineroTotalOtorgado() + '}';
    }
    
    
    
}
