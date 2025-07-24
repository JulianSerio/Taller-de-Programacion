/*
- Los jugadores son empleados que se caracterizan por el número de partidos jugados y el número de goles anotados.

jugador es el promedio de goles por partido.

- Para los jugadores: si el promedio de goles por partido es superior a 0,5 se adiciona un plus de otro sueldo básico.
 */
package tema4;

/**
 *
 * @author Usuario
 */
public class Jugador extends Empleados {
    private int partidos;
    private int goles;

    public Jugador(int partidos, int goles, String nombre, double sueldo, double antigüedad) {
        super(nombre, sueldo, antigüedad);
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
    
    public double calcularEfectividad(){
        return goles/partidos;
    }
    
    public double calcularSueldoACobrar(){
        double extra;
        
        if(this.calcularEfectividad()>0.5){
            return ((super.getSueldo()*2)+((0.10*super.getSueldo())*super.getAntigüedad()));
        }
        else
            return (super.getSueldo()+((0.10*super.getSueldo())*super.getAntigüedad()));
        
    }
    
}
