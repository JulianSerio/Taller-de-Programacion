package p5ej02;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julian
 */
public class Estacionamiento {
    private String nombre;
    private String direccion;
    private String horaApertura;
    private String horaCierre;
    private int N;
    private int M;
    private Auto [][]m;

    public Estacionamiento(String nombre, String direccion, String horaApertura, String horaCierre, int N, int M) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.N = N;
        this.M = M;
        m = new Auto[N][M];
        //iniciailizoMatrizEnNull();
    }

    public Estacionamiento(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = "08:00";
        this.horaCierre = "21:00";
        this.N = 5;
        this.M = 10;
        m = new Auto[N][M];
    }
    
    public void agregarAuto(Auto A, int X, int Y){
        m[X][Y] = A;
    }
    
   
    public int cantAutos(int Y){
        int cant = 0;
        for (int i = 0; i < N; i++){
            if (m[i][Y] != null){
                cant++;
            }
        }
        return cant;
    }
    
    
    public String obtenerRepresentacion(String patente){
        int i = 0;
        int j;
        boolean encontre = false;
        String aux = "Auto Inexistente";
        while ((i < N)&&(!encontre)){
            j = 0;
            while ((j < M)&&(!encontre)){
                if (m[i][j] != null){
                    if (m[i][j].getPatente().equals(patente)){
                        aux = "Auto en Piso: " + i + " Plaza: " + j;
                        encontre = true;
                    }
                }
                j++;
            }
            i++;
        }
        return aux;
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

    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (m[i][j] != null){
                    aux = aux + "Piso: " + i + " Plaza: " + j + " " + m[i][j] + '\n';
                }
                else{
                    aux = aux + "Piso: " + i + " Plaza: " + j + " Libre" + '\n';
                }
            }
        }
        return aux;
    }
    
    
    
    
    
}
