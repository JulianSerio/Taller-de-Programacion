/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial47;

/**
 *
 * @author Julian
 */
public class Butaca {
    private String descriptor;
    private boolean estado;
    private double precio;

    public Butaca(String descriptor, boolean estado, double precio) {
        this.descriptor = descriptor;
        this.estado = estado;
        this.precio = precio;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Butaca{" + "descriptor=" + descriptor + ", estado=" + estado + ", precio=" + precio + '}';
    }

    
    
    
    
}
