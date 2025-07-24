/*
Los entrenadores son empleados que se caracterizan por la cantidad de campeonatos ganados.

La efectividad del entrenador es el promedio de campeonatos ganados por año de antigüedad

El sueldo a cobrar es el sueldo básico más un 10% del básico por cada año de antigüedad
- Para los entrenadores: se adiciona un plus por campeonatos ganados
(5000$ si ha ganado entre 1 y 4 campeonatos; $30.000 si ha ganado entre 5 y 10 campeonatos; 50.000$ si ha ganado más de 10 campeonatos).
 */
package tema4;

/**
 *
 * @author Usuario
 */
public class Entrenador extends Empleados {
    private int campeonatos;

    public Entrenador(int campeonatos, String nombre, double sueldo, double antigüedad) {
        super(nombre, sueldo, antigüedad);
        this.campeonatos = campeonatos;
    }

    public int getCampeonatos() {
        return campeonatos;
    }

    public void setCampeonatos(int campeonatos) {
        this.campeonatos = campeonatos;
    }
    
    public double calcularEfectividad(){
        return (campeonatos/ super.getAntigüedad());
    }
    
    public double calcularSueldoACobrar(){
        double extra;
        if(campeonatos == 0){
            extra=0;
        }
        else
            if((campeonatos >= 1)&&(campeonatos <= 4)){
            extra=5000;
            }
            else
                if((campeonatos >= 5)&&(campeonatos <= 10)){
                    extra=30000;
                }
                else
                    extra=50000;
        return (super.getSueldo()+((0.10*super.getSueldo())*super.getAntigüedad()) + extra);
    }
    
}
