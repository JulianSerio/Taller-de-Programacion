/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema5.ej01;

/**
 *
 * @author Julian
 */
public class Proyecto {
    private String nombreProyecto;
    private String nombreDirector;
    private int codigo; 
    private int DIMF = 50;
    private int dimL = 0;
    private Investigador [] v = new Investigador[DIMF];

    public Proyecto(String nombreProyecto, String nombreDirector, int codigo) {
        this.nombreProyecto = nombreProyecto;
        this.nombreDirector = nombreDirector;
        this.codigo = codigo;
    }
    
    public void agregarInvestigador (Investigador in){
        v[dimL] = in;
        dimL++;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDIMF() {
        return DIMF;
    }

    public int getDimL() {
        return dimL;
    }

    @Override
    public String toString() {
        String aux = "Proyecto{" + "nombreProyecto=" + nombreProyecto + ", nombreDirector=" + nombreDirector + ", codigo=" + codigo + '}' + '\n';
        for (int i = 0; i < dimL; i++){
            aux = aux + v[i].toString() + '\n';
        }
        return aux;
    }
}
