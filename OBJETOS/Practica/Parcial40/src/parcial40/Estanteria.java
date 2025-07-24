/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial40;

/**
 *
 * @author Julian
 */
public class Estanteria {
    private int ESTANTES;
    private int LIBROS;
    private Libro [][] m;

    public Estanteria(int ESTANTES, int LIBROS) {
        this.ESTANTES = ESTANTES;
        this.LIBROS = LIBROS;
        m = new Libro[ESTANTES][LIBROS];
        //inicializoMatriz()
    }
    
    /**public void agregarLibro(Libro l){
        int i = 0;
        int j = 0;
        boolean encontre = false;
        while ((i < ESTANTES)&&(!encontre)){
            j = 0;
            while ((j < LIBROS)&&(!encontre)){
                if (m[i][j] == null){
                    m[i][j] = l; 
                    encontre = true;
                }
                j++;
            }
            i++;
        }
    }
     */
    
    public void agregarLibro(Libro l){
        int i = 0;
        int j = 0;
        boolean encontre = false;
        while(!encontre){
            j = 0;
            while((j<LIBROS)&&(!encontre)){
                if(m[i][j]==null){
                    m[i][j]=l;
                    encontre=true;
                }
                j++;
            }
            i++;
        }
    }
    public Libro sacarLibro(int X, int Y){
        Libro li = m[X][Y];
        m[X][Y] = null;
        return li;
    }
    
    public int calcular(String nombre){
        int cant = 0;
        for (int i = 0; i < ESTANTES; i++){
            for (int j = 0; j < LIBROS; j++){
                if (m[i][j] != null){
                    if (m[i][j].getAutor().equals(nombre)){
                        cant++;
                    }
                }
            }
        }
        return cant;
    }
   

    public int getESTANTES() {
        return ESTANTES;
    }

    public int getLIBROS() {
        return LIBROS;
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < ESTANTES; i++){
            for (int j = 0; j < LIBROS; j++){
                if (m[i][j] != null){
                    aux = aux + "Estante " + i + " Libro " + j + " " + m[i][j] + '\n';
                }
                else{
                    aux = aux + "Estante " + i + " Libro " + j + " No hay libro" + '\n';
                }
            }
        }
        return aux;
    }
    
    
    
    
    
}
