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

    public Colors getUserSession(String name) {

        for (UserSession u : users) {
            if (u.getUserName().equals(name)) {
                return  u.getUserColor();

            }
        }
        Colors color = new Colors();
        return color;
    }

}
