package edu.escuelaing.edu.co;

import java.util.HashMap;

public class UserSession {

    private String name;

    Colors color = new Colors();
    public UserSession(String name){
        this.color = new Colors();
        this.name = name;


    }
    public Colors getUserColor() {

        return color;
    }


    public void setUserColor(Colors color) {
        this.color = color;
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }




}
