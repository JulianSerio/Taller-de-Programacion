/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial41_2;

/**
 *
 * @author Julian
 */
public class Solista {
    private String nombre;
    private String instrumento;
    private int temasProducidos;

    public Solista(String nombre, String instrumento, int temasProducidos) {
        this.nombre = nombre;
        this.instrumento = instrumento;
        this.temasProducidos = temasProducidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public int getTemasProducidos() {
        return temasProducidos;
    }

    public void setTemasProducidos(int temasProducidos) {
        this.temasProducidos = temasProducidos;
    }
    
    
    
    
}
