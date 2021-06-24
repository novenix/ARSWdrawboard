package edu.escuelaing.edu.co;

import java.util.HashMap;

public class UserSession {
    private int r;
    private int g;
    private int b;
    private String name;

    HashMap<String,Integer > color = new HashMap<String,Integer>();
    public UserSession(String name){
        this.name = name;
        this.r = (int) Math.floor(Math.random()*250);
        this.g = (int)Math.floor(Math.random()*250);
        this.r = (int)Math.floor(Math.random()*250);
        color.put("r", r);
        color.put("g", g);
        color.put("b", b);

    }
    public HashMap getUserColor() {

        return color;
    }


    public String getUserName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }




}
