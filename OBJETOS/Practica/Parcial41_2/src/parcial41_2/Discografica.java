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
public class Discografica {
    private String nombre;
    private String ciudadResidencia;
    private int DIMF = 50;
    private int cantSolistas = 0;
    private int cantBandas = 0;
    private Banda []vBandas = new Banda[DIMF];
    private Solista []vSolistas = new Solista[DIMF];

    public Discografica(String nombre, String ciudadResidencia) {
        this.nombre = nombre;
        this.ciudadResidencia = ciudadResidencia;
    }
    
    public void agregarSolista(Solista s){
        vSolistas[cantSolistas] = s;
        cantSolistas++;
    }
    
    public void agregarBanda(Banda b){
        vBandas[cantBandas] = b;
        cantBandas++;
    }
    
    public int cantSolistasMismoInstrumento(String instrumento){
        int cant = 0;
        for (int i = 0; i < cantSolistas; i++){
            if (vSolistas[i].getInstrumento().equals(instrumento)){
                cant++;
            }
        }
        return cant;
    }
    
    public String bandaMasIntegrantes(){
        String nombre = "";
        int max = -1;
        for (int i = 0; i < cantBandas; i++){
            if (vBandas[i].getCantIntegrantes() > max){
                max = vBandas[i].getCantIntegrantes();
                nombre = vBandas[i].getNombre();
            }
        }
        return nombre;
    }
    
    public int cantBandasMismaCiudad(){
        int cant = 0;
        for (int i = 0; i < cantBandas; i++){
            if (vBandas[i].getCiudadFormacion().equals(this.getCiudadResidencia())){
                cant++;
            }
        }
        return cant;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public int getDIMF() {
        return DIMF;
    }

    public int getCantSolistas() {
        return cantSolistas;
    }

    public int cantBandas() {
        return cantBandas;
    }
    
    
    
}
