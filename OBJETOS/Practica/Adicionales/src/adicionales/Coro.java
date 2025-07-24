/*
- devolver la representación de un coro formada por el nombre del coro, todos
los datos del director y todos los datos de todos los coristas.
 */
package Adicionales;

/**
 *
 * @author PC
 */
public abstract class Coro {
    private String nombreC;
    private Director dir;

    public Coro(String nombreC, Director dir) {
        this.nombreC = nombreC;
        this.dir = dir;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }
    
    public abstract void agregarCorista(Corista c);
    public abstract boolean coroLleno();
    public abstract boolean bienOrdenado();

    @Override
    public String toString() {
        return "nombre del coro: " + nombreC + ", director: " + dir;
    }
    
    
}
