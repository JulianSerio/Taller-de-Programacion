/*
- Un evento ocasional es un recital que además tiene el motivo (a beneficio, show de TV
o show privado), el nombre del contratante del recital y el día del evento.

El evento ocasional debe saber responder al mensaje actuar de manera distinta:
- Si es un show de beneficencia se imprime la leyenda “Recuerden colaborar con…“
seguido del nombre del contratante.
- Si es un show de TV se imprime “Saludos amigos televidentes”
- Si es un show privado se imprime “Un feliz cumpleaños para…” seguido del
nombre del contratante.
Independientemente del motivo del evento, luego se imprime el listado de temas como
lo hace cualquier recital.

Si es un evento ocasional devuelve 0 si es a beneficio, 50000 si es un show de TV
y 150000 si es privado.
 */
package Adicionales;

/**
 *
 * @author PC
 */
public class Evento_ocasional extends Recital {
    private String motivo;
    private String nombreCon;
    private String dia;

    public Evento_ocasional(String motivo, String nombreCon, String dia, String nombreB, int DimF) {
        super(nombreB, DimF);
        this.motivo = motivo;
        this.nombreCon = nombreCon;
        this.dia = dia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNombreCon() {
        return nombreCon;
    }

    public void setNombreCon(String nombreCon) {
        this.nombreCon = nombreCon;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
    public String actuar(){
        String aux = "";
        if(motivo == "a beneficio"){
            aux = "Recuerden colaborar con " + nombreCon;
        }
        else{
            if(motivo=="show de TV"){
                aux = "Saludos amigos televidentes";
            }
            else{
                aux="Un feliz cumpleaños para " + nombreCon;
            }
        }
        aux= aux + super.listaTemas();
        return aux;
    }
    
    public double calcularCosto(){
        double aux=0;
        
        if(motivo=="show de TV"){
            aux = 50000;
        }
        else{
            aux=150000;
        }
        
        return aux;
    }
}
    

