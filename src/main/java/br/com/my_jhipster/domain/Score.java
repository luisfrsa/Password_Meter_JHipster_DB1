package br.com.my_jhipster.domain;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

public class Score {

    private String password;
    private Map<Integer, List<Integer>> rates = new TreeMap<>();

    public Map<Integer, List<Integer>> calculate() {
        Additions add = new Additions();
        add.setPassword(password);

        Deductions rem = new Deductions();
        rem.setPassword(password);

        rates.put(0, add.number_of_characters());
        rates.put(1, add.upper_case_letters());
        rates.put(2, add.lower_case_letters());
        rates.put(3, add.numbers());
        rates.put(4, add.symbols());
        rates.put(5, add.middle_number_or_symbols());
        rates.put(6, add.requeriments(rates));

        rates.put(7, rem.letters_only());
        rates.put(8, rem.numbers_only());
        rates.put(9, rem.repeat_char());
        rates.put(10, rem.consecutive_uppercase_letter());
        rates.put(11, rem.consecutive_lower_letter());
        rates.put(12, rem.consecutive_number());
        rates.put(13, rem.sequential_letter());
        rates.put(14, rem.sequential_number());
        rates.put(15, rem.sequential_symbol());
        rates.put(16, calcTotal(rates));

        return rates;
    }

    public List<Integer> calcTotal(Map<Integer, List<Integer>> rates) {
        List<Integer> ret = new ArrayList<>();
        Integer nTotal = 0;
        Integer scoreTotal = 0;

        for (Map.Entry<Integer, List<Integer>> entry : rates.entrySet()) {
            nTotal += entry.getValue().get(1);
            scoreTotal += entry.getValue().get(2);
        }
        if (scoreTotal > 100) {
            scoreTotal = 100;
        } else if (scoreTotal < 0) {
            scoreTotal = 0;
        }

        ret.add(16);
        ret.add(nTotal);
        ret.add(scoreTotal);
        return ret;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
