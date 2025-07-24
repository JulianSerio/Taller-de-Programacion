/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial20;

/**
 *
 * @author Julian
 */
public class Artista { 
    private String nombre;
    private String obra;

    public Artista(String nombre, String obra) {
        this.nombre = nombre;
        this.obra = obra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObra() {
        return obra;
    }

    public void setObra(String obra) {
        this.obra = obra;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", obra=" + obra;
    }
    
    
    
}
