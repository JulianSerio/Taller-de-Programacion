/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4adicional;

/**
 *
 * @author Julian
 */
public class Electoral extends Urna{
    private int cantListas;
    private int []v;

    public Electoral(int cantListas, int numero, Zona zona) {
        super(numero, zona);
        this.cantListas = cantListas;
        v = new int[cantListas];
        inicializarListas();
    }
    
    private void inicializarListas(){
        for (int i = 0; i < cantListas; i++){
            v[i] = 0;
        }
    }
    
    public boolean validarNumeroDeLista(int N){
        boolean esta = false;
        if (N <= cantListas){
            esta = true;
        }
        return esta;
    }
    
    public void votarPorLista(int I){
        v[I]++;
    }
    
    public int devolverVotosPorLista(int I){
        return v[I];
    }
    

    @Override
    public int calcularGanador() {
        int max = -1;
        int ganador = -1;
        for (int i = 0; i < cantListas; i++){
            if (v[i] > max){
                max = v[i];
                ganador = i;
            }
        }
        return ganador;
    }

    @Override
    public int calcularTotalVotos() {
        int total = 0;
        for (int i = 0; i < cantListas; i++){
            total = total + v[i];
        }
        return total + this.getVotosBlanco();
    }
    
}
