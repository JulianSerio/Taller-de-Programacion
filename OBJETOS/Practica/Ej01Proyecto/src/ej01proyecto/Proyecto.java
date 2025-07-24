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
public class Proyecto {
    private String nombre;
    private int codigo;
    private String director;
    private int DIMF = 50;
    private int dimL = 0;
    private Investigador [] v = new Investigador[DIMF];

    public Proyecto(String nombre, int codigo, String director) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.director = director;
    }
    
    public void agregarInvestigador(Investigador i){
        if (dimL < DIMF){
            v[dimL] = i;
            dimL++;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDIMF() {
        return DIMF;
    }

    public int getDimL() {
        return dimL;
    }

    @Override
    public String toString() {
        String aux =  "Proyecto{" + "nombre=" + nombre + ", codigo=" + codigo + ", director=" + director + '}' + '\n';
        for (int i = 0; i < dimL; i++){
            aux = aux + v[i].toString() + '\n';
        }
        return aux;
    }

    
}
