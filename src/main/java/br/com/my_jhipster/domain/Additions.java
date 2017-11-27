package br.com.my_jhipster.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Additions {

    private String password;

    private final String upperCase = "[^A-Z]";
    private final String lowerCase = "[^a-z]";
    private final String number = "[^0-9]";
    private final String symbol = "[A-Za-z0-9 ]";
    private final String number_or_symbol = "[a-zA-Z ]";

    public Additions() {
    }

    public List<Integer> number_of_characters() {
        List<Integer> ret = new ArrayList<>();
        Integer n = password.length();
        Integer score = (n * 4);
        ret.add(0);
        ret.add(n);
        ret.add(score);
        return ret;
    }

    public List<Integer> upper_case_letters() {
        return count_len(upperCase, 1);
    }

    public List<Integer> lower_case_letters() {
        return count_len(lowerCase, 2);
    }

    public List<Integer> numbers() {
        return count(number, 4, 3);
    }

    public List<Integer> symbols() {
        return count(symbol, 6, 4);

    }

    public List<Integer> middle_number_or_symbols() {
        List<Integer> ret = new ArrayList<>();
        Integer n = 0;
        if (password.length() > 3) {
            String subStr = password.substring(1, password.length() - 1);
            n = subStr.replaceAll(number_or_symbol, "").length();
        }
        Integer score = (n * 2);
        ret.add(5);
        ret.add(n);
        ret.add(score);
        return ret;
    }

    public List<Integer> requeriments(Map<Integer, List<Integer>> result) {
        List<Integer> ret = new ArrayList<>();
        Integer n = 0;
        Integer score = 0;

        for (Map.Entry<Integer, List<Integer>> entry : result.entrySet()) {
            if (entry.getKey() <= 4) {
                if (entry.getValue().get(2) > 0) {
                    n++;
                }
            }
        }
        if (password.length() >= 8 && n >= 4) {
            score = (n * 2);
        }
        ret.add(6);
        ret.add(n);
        ret.add(score);
        return ret;

    }
 public List<Integer> count_len(String pattern, Integer code) {
        List<Integer> ret = new ArrayList<>();
        Integer score = 0;
        Integer len = password.length();
        Integer n = password.replaceAll(pattern, "").length();
        if (n > 0) {
            score = ((len - n) * 2);
        }
        ret.add(code);
        ret.add(n);
        ret.add(score);
        return ret;
    }

    public List<Integer> count(String pattern, Integer mul, Integer code) {
        List<Integer> ret = new ArrayList<>();
        Integer n = password.replaceAll(pattern, "").length();
        Integer score = (n * mul);
        ret.add(code);
        ret.add(n);
        ret.add(score);
        return ret;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
