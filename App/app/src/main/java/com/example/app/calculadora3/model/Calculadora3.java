package com.example.app.calculadora3.model;

public class Calculadora3 {
    double valor1, valor2; // Atributos
    public Calculadora3() { }

    // Construtores
    public Calculadora3(double v1, double v2) {
        setValor1(v1);
        setValor2 (v2);
    }
    public void setValor1(double valor){
        valor1 = valor;
    }

    public double getValor1() {
        return valor1;
    }

    public void setValor2(double valor) {
        valor2 = valor;
    }

    public double getValor2() {
        return valor2;
    }
    public double somar(){
        return valor1 + valor2;
    }
    public double subt(){
        return valor1 - valor2;
    }
    public double mult(){
        return valor1 * valor2;
    }
    public double divis(){
        return valor1 / valor2;
    }
    public double expo(){
        return Math.pow(valor1, valor2);
    }
    public double radic(){
        return Math.pow(valor1,1.0/valor2);
    }

    public String formatar(double valor, int nc){
        return String.format("%."+ String.valueOf(nc) + "f", valor);
    }
}

