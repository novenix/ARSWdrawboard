package edu.escuelaing.edu.co;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Memory {
    private static final Memory instance = new Memory();
    private List<UserSession> users = new ArrayList<UserSession>();
    private List<List<Integer>> draws = new ArrayList<>();
    public static Memory getInstance() {
        return instance;
    }

    public void add(UserSession user) {
        users.add(user);
    }

    public String toString() {
        return users.toString();
    }

    public void addDraw(List<Integer> draw) {
        draws.add(draw);
    }

    public List<List<Integer>> getDraws() {
        return draws;
    }

    public void restart() {
        draws.clear();
    }
    public HashMap createColor(){
        HashMap color = new HashMap<String,Integer>(); ;

        color.put("r", (int)Math.floor(Math.random()*253+1));
        color.put("g", (int) Math.floor(Math.random()*253+1));
        color.put("b", (int)Math.floor(Math.random()*253+1));
        return color;
    }
    public HashMap getUserSession(String name) {
        HashMap color = createColor();
        for (UserSession u : users) {
            if (u.getUserName().equals(name)) {
                color = u.getUserColor();
                break;
            }
        }

        return color;
    }

}
