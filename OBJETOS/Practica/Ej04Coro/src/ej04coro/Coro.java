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
public abstract class Coro {
    private String nombre;
    private Director director;

    public Coro(String nombre, Director director) {
        this.nombre = nombre;
        this.director = director;
    }
    
    public abstract void agregarCorista(Corista c);
    public abstract boolean estaLleno();
    public abstract boolean bienFormado();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Coro{" + "nombre=" + nombre + ", director=" + director + '}' + '\n';
    }
    
    
    
    
}
