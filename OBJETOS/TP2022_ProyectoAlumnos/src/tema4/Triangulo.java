/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Julian
 */
public class Triangulo extends Figura {
   private double lado1;
   private double lado2;
   private double lado3;


    public Triangulo(double lado1, double lado2, double lado3, String colorRelleno, String colorLinea) {
        super(colorRelleno,colorLinea);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
   
    @Override
    public double calcularPerimetro (){
        return this.getLado1() + lado2 + getLado3();  
    }
    
    @Override
    public double calcularArea() {
        double s = (this.getLado1() + this.getLado2() + this.getLado3()) / 2;
        double aux = Math.sqrt( s*( s - this.getLado1())*(s - this.getLado2())*(s - this.getLado3()));
        return aux;
    }

    @Override
    public String toString() {
        return "Triangulo{" + "lado1=" + lado1 + ", lado2=" + lado2 + ", lado3=" + lado3 + '}' + super.toString();
    }    
}
