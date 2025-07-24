/*
- Una gira es un recital que además tiene un nombre y las “fechas” donde se repetirá la
actuación. De cada “fecha” se conoce la ciudad y el día. Además la gira guarda el
número de la fecha en la que se tocará próximamente (actual).

- agregarFecha que recibe una “fecha” y la agrega adecuadamente.

- La gira debe responder al mensaje actuar de manera distinta.
Imprime la leyenda “Buenas noches …” seguido del nombre de la ciudad de la fecha “actual”. Luego
debe imprimir el listado de temas como lo hace cualquier recital. Además debe
establecer la siguiente fecha de la gira como la nueva “actual”.

Las giras deben devolver 30000 por cada fecha de la misma.
 */
package Adicionales;

/**
 *
 * @author PC
 */
public class Gira extends Recital {
    private String nombreG;
    private Fecha [] fechas;
    private int fechaA = 0;
    private int DimL=0;
    private int cantF;

    public Gira(String nombreG, int DimF, String nombreB, int cantF) {
        super(nombreB, DimF);
        this.nombreG = nombreG;
        this.cantF = cantF;
        fechas=new Fecha [cantF];
    }

    public void agregarFecha(Fecha fecha){
        if(DimL < cantF){
            fechas[DimL]=fecha;
            DimL++;
        }
    }

    public String actuar(){
        String aux="";
        if(fechaA < cantF){
            aux = "buenas noches " + fechas[fechaA].getCiudad() + super.listaTemas();
            fechaA++;
        }
        return aux;
    }
    
    public String getNombreG() {
        return nombreG;
    }

    public void setNombreG(String nombreG) {
        this.nombreG = nombreG;
    }
    
    public double calcularCosto(){
        double aux;
        
        aux = (30000 * cantF);
        
        return aux;
    }
    
}
