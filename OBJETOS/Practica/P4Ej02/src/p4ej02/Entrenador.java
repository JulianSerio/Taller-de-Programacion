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
public class Entrenador extends Empleado{
    private int cantCampeonatos;

    public Entrenador(int cantCampeonatos, String nombre, double sueldoBasico, int antiguedad) {
        super(nombre, sueldoBasico, antiguedad);
        this.cantCampeonatos = cantCampeonatos;
    }

    public int getCantCampeonatos() {
        return cantCampeonatos;
    }

    public void setCantCampeonatos(int cantCampeonatos) {
        this.cantCampeonatos = cantCampeonatos;
    }

    @Override
    public double calcularEfectividad() {
        return cantCampeonatos / this.getAntiguedad();
    }
    
    public double calcularSueldoACobrar(){
        double aux = 0;
        if ((cantCampeonatos >= 1) && (cantCampeonatos <=4)){
            aux = 5000;
        }
        else{
            if ((cantCampeonatos >= 5) && (cantCampeonatos <=10)){
                aux = 30000;
            }
            else{
                if (cantCampeonatos > 10){
                    aux = 50000;
                }
            }
        }
        return aux + super.calcularSueldoACobrar();
    }
    
    
}
