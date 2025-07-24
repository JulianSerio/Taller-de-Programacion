/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Julian
 */
public class Jugador extends Empleado{
    private int partidos;
    private int goles;

    public Jugador(int partidos, int goles, String nombre, double sueldo, int antiguedad) {
        super(nombre, sueldo, antiguedad);
        this.partidos = partidos;
        this.goles = goles;
    }
    
    public int getPartidos() {
        return partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    @Override
    public double calcularEfectividad() {
        return goles / partidos;
    }

    @Override
    public double calcularSueldo() {
        double aux = 0;
        if (this.calcularEfectividad() > 0.5){
            aux = aux + this.getSueldo();
        }
        return aux;
    }   
}
