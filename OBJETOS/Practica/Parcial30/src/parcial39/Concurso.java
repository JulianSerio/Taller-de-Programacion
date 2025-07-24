/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial39;

/**
 *
 * @author Julian
 */
public class Concurso {
    private int N;
    private int dimL = 0;
    private Pareja []v;

    public Concurso(int N) {
        this.N = N;
        v = new Pareja[N];
    }
    
    public void agregarPareja(Pareja p){
        v[dimL] = p;
        dimL++;
    }
    
    public Pareja mayorDiffEdad(){
        Pareja p = null;
        int max = -1;
        for (int i = 0; i < dimL; i++){
            System.out.println(v[i].diferenciaEdad());
            if (v[i].diferenciaEdad() > max){
                max = v[i].diferenciaEdad();
                p = v[i];
            }
        }
        return p;
        
    }

    public int getN() {
        return N;
    }
}
