/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adicionalp4;

/**
 *
 * @author Julian
 */
public class UrnaElectoral extends Urna{
    private int cantListas;
    private int []v;

    public UrnaElectoral(int cantListas, int numero, Zona zona) {
        super(numero, zona);
        this.cantListas = cantListas;
        v = new int [cantListas];
        inicializo();
    }
    
    private void inicializo(){
        for (int i = 0; i < cantListas; i++){
            v[i] = 0;
        }
    }
    
    public boolean validarNumeroLista(int N){
        boolean valido = false;
        if (N <= this.cantListas){
            valido = true;
            
        }
        return valido;
    }
    
    public void votarLista(int N){
        v[N]++;
        System.out.println(v[N]);
    }
    
    public int devolverVotosPorLista(int I){
        return v[I];
    }

    public int getCantListas() {
        return cantListas;
    }
    
    
    

    @Override
    public int calcularGanador() {
        int max = -1;
        int li = 0;
        for (int i = 0; i < cantListas; i++){
            if (v[i] > max){
                max = v[i];
                li = i;
            }
        }
        return li;
    }

    @Override
    public int calcularTotalVotos() {
        int aux = this.getVotosBlanco();
        for (int i = 0; i < this.cantListas; i++){
            aux = aux + v[i];
        }
        return aux;
    }
    
    
    
    
}
