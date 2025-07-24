/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial41;

/**
 *
 * @author Julian
 */
public class Discografica {
    private String dueno;
    private String nombre;
    private String ciudad;
    private int DIMF = 50;
    private int dimLSolistas = 0;
    private int dimLBandas = 0;
    private Solista [] vS = new Solista[DIMF];
    private Banda [] vB = new Banda[DIMF];

    public Discografica(String dueno, String nombre, String ciudad) {
        this.dueno = dueno;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    
    public void agregarSolista(Solista s){
        if (dimLSolistas < DIMF){
            vS[dimLSolistas] = s;
            dimLSolistas++;
        }
    }
    
    public void agregarBanda(Banda b){
        if (dimLBandas < DIMF){
            vB[dimLBandas] = b;
            dimLBandas++;
        }
    }
    
    public String bandaMasIntegrantes(){
        String nombre = "";
        int max = -1;
        for (int i = 0; i < this.dimLBandas; i++){
            if (vB[i].getMiembros() > max){
                max = vB[i].getMiembros();
                nombre = vB[i].getNombre();
            }
        }
        return nombre;
    }
    
    public int cantBandasRepresentabas(){
        return this.getDimLBandas();
    }
    
    public int cantInstrumentos(String instrumento){
        int cont =0;
        for (int i = 0; i < this.dimLSolistas; i++){
            if (vS[i].getInstrumento().equals(instrumento)){
                cont++;
            }
        }
        return cont;
    }
    
    public int cantBandasMismaCiudad(){
        int cont =0;
        for (int i = 0; i < dimLBandas; i++){
            if (vB[i].getCiudad().equals(this.ciudad)){
                cont++;
            }
        }
        return cont;
    }


    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getDIMF() {
        return DIMF;
    }

    public int getDimLSolistas() {
        return dimLSolistas;
    }

    public int getDimLBandas() {
        return dimLBandas;
    }

    
    
    
}
