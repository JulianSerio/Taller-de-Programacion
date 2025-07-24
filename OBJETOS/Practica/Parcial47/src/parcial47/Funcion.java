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
public class Funcion {
    private String titulo;
    private String fecha;
    private String hora;
    private int FILAS;
    private int BUTACAS;
    private Butaca [][]m;

    public Funcion(String titulo, String fecha, String hora, int FILAS, int BUTACAS) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
        this.FILAS = FILAS;
        this.BUTACAS = BUTACAS;
        m = new Butaca[FILAS][BUTACAS];
        inicializoButacas();
    }
    
    private void inicializoButacas(){
        for (int i = 0; i < FILAS; i++){
            for (int j = 0; j < BUTACAS; j++){
                m[i][j] = new Butaca("Butaca " + i + j,false,800+100*i);
            }
        }
    }
    
    public double ocuparButaca(int F,int B){
        m[F][B].setEstado(true);
        return m[F][B].getPrecio();
    }
    
    public void desocuparButacas (int F){
        for (int j = 0; j < BUTACAS; j++){
            if (m[F][j].isEstado()){
                m[F][j].setEstado(false);
            }
        }
    }
    
    public String representacion (int B){
        String aux = "";
        for (int i = 0; i < FILAS; i++){
            aux = aux + m[i][B] + '\n';
        }
        return aux;
    }

    public int getFILAS() {
        return FILAS;
    }

    public int getBUTACAS() {
        return BUTACAS;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        String aux = "Titulo: " + titulo + " Fecha: " + fecha + " Hora: " + hora + '\n';
        for (int i = 0; i < FILAS; i++){
            for (int j = 0; j < BUTACAS; j++){
                aux = aux + m[i][j] + '\n';
            }
        }
        return aux;
    }
    
    
    
    
    
}
