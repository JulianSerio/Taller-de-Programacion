/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema5.ej01;

/**
 *
 * @author Julian
 */
public class Subsidio {
    private double monto;
    private boolean otorgado = false;
    private String motivo;

    public Subsidio(double monto, String motivo) {
        this.monto = monto;
        this.motivo = motivo;
        otorgado = false;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isOtorgado() {
        return otorgado;
    }

    public void setOtorgado(boolean otorgado) {
        this.otorgado = otorgado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
 
}
