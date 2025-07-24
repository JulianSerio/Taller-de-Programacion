/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema5.ej02;

/**
 *
 * @author Julian
**/
public class Estacionamiento {
    private String nombre;
    private String direccion;
    private String horaApertura;
    private String horaCierre;
    private int FILAS;
    private int COLUMNAS;
    private Auto [][] m;
    
    public Estacionamiento(String nombre, String direccion){
        this.direccion = direccion;
        this.nombre = nombre;
        horaApertura = "8:00";
        horaCierre = "21:00";
        FILAS = 5;
        COLUMNAS = 10;
    }

    public Estacionamiento(String nombre, String direccion, String horaApertura, String horaCierre, int FILAS, int COLUMNAS) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.FILAS = FILAS;
        this.COLUMNAS = COLUMNAS;
        m = new Auto[FILAS][COLUMNAS];
    }

    public void agregarAuto (Auto a, int x, int y){
        m[x-1][y-1] = a;
    }
    
    public String buscarPatente (String patente){
        String aux = "Auto Inexistente";
        int i = 0, j = 0;
        boolean encontre = false;
        while ((i < FILAS)&&(!encontre)){
            j = 0;
            while ((j < COLUMNAS)&&(!encontre)){
                if (m[i][j] != null){
                    if (m[i][j].getPatente().equals(patente)){	
                        aux = "El auto esta en el Piso: " + (i+1) + " Plaza: " + (j+1);
                        encontre = true;
                    }
                }
                j++;
            }
            i++;
        }
        return aux;
    }
    public int cantAutosPlaza (int plaza){
        int cont = 0;
        for (int i = 0; i < FILAS; i++){
            if (m[i][plaza] != null){
                cont++;
            }
        }
        return cont;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < FILAS; i++){
            for (int j = 0; j < COLUMNAS; j++){
                if (m[i][j] != null){
                    aux = aux + "Piso " + (i+1) + " Plaza " + (j+1) + ": " + m[i][j] + '\n';
                }
                else{
                    aux = aux + "Piso " + (i+1) + " Plaza " + (j+1) + ": " + "Libre" + '\n';
                }
            }
        }
        return aux;
    } 
    
}
