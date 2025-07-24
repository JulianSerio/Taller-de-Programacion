/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej03recitales;

/**
 *
 * @author Julian
 */
public class Gira extends Recital{
    private String nombre;
    private int FECHAS;
    private int act = 0;
    private Fecha [] v;

    public Gira(String nombre, int DIMF, String banda, int FECHAS) {
        super(banda, DIMF);
        this.nombre = nombre;
        this.FECHAS = FECHAS;
        v = new Fecha[FECHAS];
    }

   
    
    public void agregarFecha(Fecha f){
        int i =0;
        while (v[i] != null){
            i++;
        }
        v[i] = f;  
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFECHAS() {
        return FECHAS;
    }


    @Override
    public String actuar() {    
        String aux = "Buenas noches... " + v[act].getCiudad() + '\n' 
                + super.toString();
        if (act < FECHAS){
            act++;
        }
        return aux;
    }

    @Override
    public double calcularCosto() {
        return 30000 * FECHAS;
    }
    
    
    
    
    
}
