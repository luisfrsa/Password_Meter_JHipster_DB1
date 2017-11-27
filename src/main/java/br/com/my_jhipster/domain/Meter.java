package br.com.my_jhipster.domain;


import java.util.List;
import java.util.Map;

public class Meter {
    private String password;
    
    public Meter() {}

    public Map<Integer, List<Integer>> calcScore() {
        Score score = new Score();
        score.setPassword(password);
        return score.calculate();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
