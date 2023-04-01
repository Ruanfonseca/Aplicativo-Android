package com.example.app.calculadora_1.model;

import static java.lang.Math.pow;

public class Calculadora {

    double v1, v2;

    public Calculadora(){

    }
    public Calculadora(double v1, double v2){
        this.v1 = v1;
        this.v2 = v2;
    }

    public double getV1() {
        return v1;
    }

    public void setV1(double v1) {
        this.v1 = v1;
    }

    public double getV2() {
        return v2;
    }

    public void setV2(double v2) {
        this.v2 = v2;
    }
    public double somar(){
        return v1 + v2;
    }
    public double subtracao(){
        return v1 - v2;
    }
    public double multiplicacao(){
        return v1 * v2;
    }
    public double divisao(){
        return v1 / v2;
    }

    public double radiciacao(){
        return (pow(v1,(1.0/v2)));
    }
    public double exponenciacao(){
        return pow(v1,v2);
    }

    public String formatar(double v, int nc){
        return String.format("%." + String.valueOf(nc)+"f",v);
    }
}
