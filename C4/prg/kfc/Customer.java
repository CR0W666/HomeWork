package C4.prg.kfc;

import java.util.List;
import java.util.ArrayList;


public class Customer {
    private List<Integer> history;



    public Customer() {
        this.history = new ArrayList<>();
    }

    public void addToHistory(int amount) {
        this.history.add(amount);
    }

    public List<Integer> getHistory() {
        return this.history;
    }

}
