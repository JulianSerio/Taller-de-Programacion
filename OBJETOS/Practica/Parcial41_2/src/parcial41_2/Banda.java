/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial41_2;

/**
 *
 * @author Julian
 */
public class Banda {
    private String nombre;
    private String ciudadFormacion;
    private int cantIntegrantes;

    public Banda(String nombre, String ciudadFormacion, int cantIntegrantes) {
        this.nombre = nombre;
        this.ciudadFormacion = ciudadFormacion;
        this.cantIntegrantes = cantIntegrantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudadFormacion() {
        return ciudadFormacion;
    }

    public void setCiudadFormacion(String ciudadFormacion) {
        this.ciudadFormacion = ciudadFormacion;
    }

    public int getCantIntegrantes() {
        return cantIntegrantes;
    }

    public void setCantIntegrantes(int cantIntegrantes) {
        this.cantIntegrantes = cantIntegrantes;
    }
    
    
    
}
