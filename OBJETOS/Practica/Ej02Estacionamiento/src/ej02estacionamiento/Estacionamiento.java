/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej02estacionamiento;

/**
 *
 * @author Julian
 */
public class Estacionamiento {
    private String nombre;
    private String horaApertura;
    private String horaCierre;
    private String direccion;
    private int FILAS;
    private int COLUMNAS;
    private Auto [][]m;

    public Estacionamiento(String nombre, String horaApertura, String horaCierre, String direccion, int FILAS, int COLUMNAS) {
        this.nombre = nombre;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.direccion = direccion;
        this.FILAS = FILAS;
        this.COLUMNAS = COLUMNAS;
        m = new Auto[FILAS][COLUMNAS];
    }

    public Estacionamiento(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = "8:00";
        this.horaCierre = "21:00";
        this.FILAS = 5;
        this.COLUMNAS = 10;
    }
    
    public void agregarAuto(int X, int Y, Auto A){
        m[X][Y] = A;
    }
    
    public int cantAutos(int Y){
        int cant = 0;
        for (int x = 0; x < FILAS; x++){
            if (m[x][Y] != null){
                cant++;
            }
        }
        return cant;
    }
    
    public String buscarPatente(String patente){
        String aux = "Auto inexistente";
        boolean encontre = false;
        int i = 0;
        int j;
        while ((i < FILAS) && (!encontre)){
            j = 0;
            while ((j < COLUMNAS) && (!encontre)){
                if (m[i][j] != null){
                    if (m[i][j].getPatente().equals(patente)){
                        aux = "El auto se encuentra en: " + (i+1) + " " + (j + 1);
                        encontre = true;
                    }
                }
                j++;
            }
            i++;
        }
        return aux;
    }
    

    public int getFILAS() {
        return FILAS;
    }

    public int getCOLUMNAS() {
        return COLUMNAS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(String horaApertura) {
        this.horaApertura = horaApertura;
    }

    public String getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(String horaCierre) {
        this.horaCierre = horaCierre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < FILAS; i++){
            for (int j = 0; j < COLUMNAS; j++){
                if (m[i][j] != null){
                    aux = aux + "Piso " + (i+1) + " " + "Plaza " + (j+1) + " " + m[i][j] + '\n';
                }
                else{
                    aux = aux + "Piso " + (i+1) + " " + "Plaza " + (j+1) + " " + " LIBRE " + '\n';
                }
            }
        }
        return aux;
    }
    
    
    
    
    
    
    
}
