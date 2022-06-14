package com.mdaszuta.algoritms;

public class AlgorithmParams {

    private AlgorithmType type;

    private float a = 1f;

    private float b = 0.25f;

    private float c = 1f;

    private float n = 1f;

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }

    public float getN() {
        return n;
    }

    public void setN(float n) {
        this.n = n;
    }

    public AlgorithmType getType() {
        return type;
    }

    public void setType(AlgorithmType type) {
        this.type = type;
    }
}
