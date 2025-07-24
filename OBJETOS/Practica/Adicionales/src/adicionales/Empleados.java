/*
- Cualquier empleado se caracteriza por su nombre, sueldo básico y antigüedad.

- Cualquier empleado debe responder al mensaje calcularEfectividad.
La efectividad del entrenador es el promedio de campeonatos ganados por año de antigüedad,
mientras que la del jugador es el promedio de goles por partido.

- Cualquier empleado debe responder al mensaje calcularSueldoACobrar.
El sueldo a cobrar es el sueldo básico más un 10% del básico por cada año de antigüedad y además:
- Para los jugadores: si el promedio de goles por partido es superior a 0,5 se adiciona un plus de otro sueldo básico.
- Para los entrenadores: se adiciona un plus por campeonatos ganados
(5000$ si ha ganado entre 1 y 4 campeonatos; $30.000 si ha ganado entre 5 y 10 campeonatos; 50.000$ si ha ganado más de 10 campeonatos).
 */
package tema4;

/**
 *
 * @author Usuario
 */
public abstract class Empleados {
    private String nombre;
    private double sueldo;
    private double antigüedad;

    public Empleados(String nombre, double sueldo, double antigüedad) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.antigüedad = antigüedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getAntigüedad() {
        return antigüedad;
    }

    public void setAntigüedad(double antigüedad) {
        this.antigüedad = antigüedad;
    }
    
    public abstract double calcularEfectividad();
    
    public abstract double calcularSueldoACobrar();

    @Override
    public String toString() {
        return "nombre: " + nombre + ", sueldo a cobrar: " + this.calcularSueldoACobrar() + ", efectividad: " + this.calcularEfectividad();
    }
    
    
}
