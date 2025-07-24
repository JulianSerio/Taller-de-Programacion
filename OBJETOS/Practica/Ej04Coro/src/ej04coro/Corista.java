/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej04coro;

/**
 *
 * @author Julian
 */
public class Corista {
    private String nombre;
    private int dni;
    private int edad;
    private int tono;

    public Corista(String nombre, int dni, int edad, int tono) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.tono = tono;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTono() {
        return tono;
    }

    public void setTono(int tono) {
        this.tono = tono;
    }

    @Override
    public String toString() {
        return "Corista{" + "nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", tono=" + tono + '}';
    }
    
    
    
}
