/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial46_2;

/**
 *
 * @author Julian
 */
public class Funcion {
    private String hora;
    private String fecha;
    private String titulo;
    private int N;
    private int M;
    private Butaca [][]m;

    public Funcion(String hora, String fecha, String titulo, int N, int M) {
        this.hora = hora;
        this.fecha = fecha;
        this.titulo = titulo;
        this.N = N;
        this.M = M;
        m = new Butaca[N][M];
        inicializarButacas();
    }
    
    private void inicializarButacas(){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                m[i][j] = new Butaca("Butaca " + i + j,800+100*i);
            }
        }
    }
    
    public double ocuparButaca(int F, int B){
        m[F][B].setOcupada(true);
        return m[F][B].getPrecio();
    }
    
    public void desocuparButacas(int F){
        for (int j = 0; j < M; j++){
            m[F][j].setOcupada(false);
        }
    }
    
    public String obtenerRepresentacion(int B){
        String aux = "";
        for (int i = 0; i < N; i++){
            aux = aux + m[i][B] + '\n';
        }
        return aux;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }

    @Override
    public String toString() {
        String aux = "Funcion: " + " Titulo: " + titulo + " Fecha: " + fecha + " Hora: " + hora + '\n';
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                aux = aux + m[i][j] + '\n';
            }
        }
        return aux;
    }
    
    
    
    
    
    
}
