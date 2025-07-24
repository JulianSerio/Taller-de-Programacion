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
public class Alumno {
    private String nombre;
    private int edad;
    private String instrumento;
    private double puntaje;

    public Alumno(String nombre, int edad, String instrumento, double puntaje) {
        this.nombre = nombre;
        this.edad = edad;
        this.instrumento = instrumento;
        this.puntaje = puntaje;
    }
    
    public void modificarPuntaje(double puntaje, String nom){
        if (nom.equals(this.nombre)){
            this.puntaje = puntaje;
        }
    }
  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", edad=" + edad + ", instrumento=" + instrumento + ", puntaje=" + puntaje + '}';
    }  
  
}
