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
public class Entrenador extends Empleado{
    private int cantCampeonatos;

    public Entrenador(int cantCampeonatos, String nombre, double sueldo, int antiguedad) {
        super(nombre, sueldo, antiguedad);
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
        return cantCampeonatos / super.getAntiguedad();
    }

    @Override
    public double calcularSueldo() {
        double aux = 0;
        if ((cantCampeonatos >= 1) || (cantCampeonatos <=4)){
            aux = aux + 5000;
        }
        else{
            if ((cantCampeonatos >= 5) || (cantCampeonatos <=10)){
                aux = aux + 30000;
            }
            else{
                if (cantCampeonatos > 10){
                    aux = aux + 50000;
                }
            }
        }
        return aux;
    }
   
}
