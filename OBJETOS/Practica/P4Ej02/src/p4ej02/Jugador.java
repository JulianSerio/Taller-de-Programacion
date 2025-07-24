/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4ej02;

/**
 *
 * @author Julian
 */
public class Jugador extends Empleado {
    private int partidosJugados;
    private int goles;

    public Jugador(int partidosJugados, int goles, String nombre, double sueldoBasico, int antiguedad) {
        super(nombre, sueldoBasico, antiguedad);
        this.partidosJugados = partidosJugados;
        this.goles = goles;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    @Override
    public double calcularEfectividad() {
        return goles / this.partidosJugados;
    }
    
    @Override
    public double calcularSueldoACobrar(){
        double aux = this.getSueldoBasico();
        if (this.calcularEfectividad() > 0.5){
            aux = aux + this.getSueldoBasico();
        }
        return aux + super.calcularSueldoACobrar();
    }
    
    
}
