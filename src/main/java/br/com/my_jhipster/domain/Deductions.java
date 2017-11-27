package br.com.my_jhipster.domain;

import java.util.List;
import java.util.ArrayList;

public class Deductions {

    private String password;

    private final String only_letter = "[A-Za-z ]";
    private final String only_number = "[0-9]";
    private final String symbol_seq = "[^A-Za-z0-9]";
    private final String conseq_upper = "[A-Z]";
    private final String conseq_lower = "[a-z]";

    public Deductions() {
    }

    public List<Integer> letters_only() {
        return only(only_letter, 7);
    }

    public List<Integer> numbers_only() {
        return only(only_number, 8);
    }

    public List<Integer> repeat_char() {
        List<Integer> retorno = new ArrayList<>();
        Integer n = 0;
        Integer uni_char;
        Double count = new Double(0);
        boolean found;
        for (int i = 0; i < password.length(); i++) {
            found = false;
            for (int j = 0; j < password.length(); j++) {
                if (password.charAt(i) == password.charAt(j) && i != j) {
                    found = true;
                    count += Math.abs(password.length() / (j - i));
                }
            }
            if (found) {
                n++;
                uni_char = password.length() - n;
                if (uni_char > 0) {
                    count = Math.ceil(count / uni_char);
                } else {
                    count = Math.ceil(count);
                }
            }
        }
        retorno.add(9);
        retorno.add(n);
        retorno.add(Integer.valueOf(count.intValue()) * (-1));
        return retorno;
    }

    public List<Integer> consecutive_uppercase_letter() {
        return this.consecutive(conseq_upper, 10);

    }

    public List<Integer> consecutive_lower_letter() {
        return this.consecutive(conseq_lower, 11);
    }

    public List<Integer> consecutive_number() {
        return this.consecutive(only_number, 12);

    }

    public List<Integer> sequential_letter() {
        List<Integer> retorno = new ArrayList<>();
        List<String> seq_alpha = new ArrayList<>();
        String alpha_cres = "abcdefghijklmnopqrstuvwxyz";
        alpha_cres = alpha_cres + new StringBuilder(alpha_cres).reverse().toString();
        String seq;
        Integer count;
        Integer score;
        Integer n = 0;
        for (int i = 0; i < alpha_cres.length(); i++) {
            if ((i + 2) < alpha_cres.length()) {
                seq = String.valueOf(alpha_cres.charAt(i)) + String.valueOf(alpha_cres.charAt(i + 1)) + String.valueOf(alpha_cres.charAt(i + 2));
                seq_alpha.add(seq);
            }
        }
        return this.sequential(seq_alpha, 13, only_letter, password.toLowerCase());
    }

    public List<Integer> sequential_number() {
        List<Integer> retorno = new ArrayList<>();
        List<String> seq_number = new ArrayList<>();
        String numeros_cres = "0123456789";
        numeros_cres = numeros_cres + new StringBuilder(numeros_cres).reverse().toString();
        String seq;
        Integer count;
        Integer score;
        Integer n = 0;
        for (int i = 0; i < numeros_cres.length(); i++) {
            if ((i + 2) < numeros_cres.length()) {
                seq = String.valueOf(numeros_cres.charAt(i)) + String.valueOf(numeros_cres.charAt(i + 1)) + String.valueOf(numeros_cres.charAt(i + 2));
                seq_number.add(seq);
            }
        }
        return this.sequential(seq_number, 15, only_number, password);
    }

    public List<Integer> sequential_symbol() {
        List<Integer> retorno = new ArrayList<>();
        List<String> seq_alpha = new ArrayList<>();
        String alpha_cres = ")!@#$%^&*(";
        alpha_cres = alpha_cres + new StringBuilder(alpha_cres).reverse().toString();
        String seq;
        Integer count;
        Integer score;
        Integer n = 0;
        for (int i = 0; i < alpha_cres.length(); i++) {
            if ((i + 2) < alpha_cres.length()) {
                seq = String.valueOf(alpha_cres.charAt(i)) + String.valueOf(alpha_cres.charAt(i + 1)) + String.valueOf(alpha_cres.charAt(i + 2));
                seq_alpha.add(seq);
            }
        }
        return this.sequential(seq_alpha, 14, symbol_seq, password);
    }

    public List<Integer> consecutive(String pattern, Integer code) {
        List<Integer> retorno = new ArrayList<>();
        Integer score;
        Integer n = 0;
        Integer i = 0;
        while (i < password.length()) {
            if ((i + 1) < password.length() && String.valueOf(password.charAt(i)).replaceAll(pattern, "").equals("")) {
                while ((i + 1) < password.length() && String.valueOf(password.charAt(i + 1)).replaceAll(pattern, "").equals("")) {
                    n++;
                    i++;
                }
            }
            i++;
        }
        score = -n * 2;
        retorno.add(code);
        retorno.add(n);
        retorno.add(score);
        return retorno;
    }

    public List<Integer> only(String pattern, Integer code) {
        List<Integer> retorno = new ArrayList<>();
        Integer score;
        Integer n = 0;
        if (password.replaceAll(pattern, "").equals("")) {
            n = password.length();
        }
        retorno.add(code);
        retorno.add(n);
        retorno.add(-n);
        return retorno;
    }

    public List<Integer> sequential(List<String> array_seq, Integer code, String pattern, String pass) {
        List<Integer> retorno = new ArrayList<>();
        List<String> founds = new ArrayList<>();
        Integer n = 0;

        String seq;
        Integer score;

        for (int i = 0; i < pass.length(); i++) {
            if (String.valueOf(pass.charAt(i)).replaceAll(pattern, "").equals("")) {
                seq = "";
                for (String s : array_seq) {
                    if (pass.charAt(i) == s.charAt(0)) {
                        seq = s;
                        break;
                    }
                }
                if (i + 3 <= pass.length()) {
                    if (pass.substring(i, (i + 3)).equals(seq) && !founds.contains(seq)) {
                        n++;
                        founds.add(seq);
                    }
                }

            }
        }
        score = -n * 3;
        retorno.add(code);
        retorno.add(n);
        retorno.add(score);
        return retorno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
