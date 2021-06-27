package edu.escuelaing.edu.co;

import java.awt.*;

public class Colors {
    private int r;
    private int g;
    private int b;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    public Colors(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Colors(){
        this.r = (int) Math.floor(Math.random()*252);
        this.g = (int)Math.floor(Math.random()*252);
        this.r = (int)Math.floor(Math.random()*252);
    }

}
