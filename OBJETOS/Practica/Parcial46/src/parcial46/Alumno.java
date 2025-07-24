/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial46;

/**
 *
 * @author Julian
 */
public class Alumno {
    private String nombre;
    private int dni;
    private int tema = -1;

    public Alumno(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
        tema = -1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", dni=" + dni + ", tema=" + tema + '}';
    }
    
    
    
    
}
