/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial46_2;

/**
 *
 * @author Julian
 */
public class Butaca {
    private String descriptor;
    private boolean ocupada = false;
    private double precio;

    public Butaca(String descriptor, double precio) {
        this.descriptor = descriptor;
        this.precio = precio;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Butaca{" + "descriptor=" + descriptor + ", ocupada=" + ocupada + ", precio=" + precio + '}';
    }
    
    
    
}
