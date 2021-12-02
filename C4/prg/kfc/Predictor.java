package C4.prg.kfc;

import java.util.Random;
import java.util.List;
import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Map;

public class Predictor {

    private Random r = new Random();

    private int randomOrder;
    private int max;
    private int min;
    private double avg;
    private int mostCommon;
    private List<Integer> history;

    public int predictNextOrder(Customer customer) {
        updateVariables(customer);
        if(this.history.isEmpty()) return 2; //nothing to predict. 
        if(this.history.size() < 5) return randomOrder; //too little data, returning random order from the past.
        
        //conditions
        if(min == max) return max; //always orders the same
        //TODO         
    
        //guess well never know
        return (int) ((r.nextInt(1000) > 500.0) ? mostCommon : Math.round(avg));
    }

    
    private void updateVariables(Customer customer) {
        this.history = customer.getHistory();
        this.randomOrder = customer.getHistory().get(r.nextInt(customer.getHistory().size()));
        this.max = Collections.max(history);
        this.min = Collections.min(history);
        this.avg = history.stream().mapToDouble(i -> i).average().getAsDouble();
        this.mostCommon = history.stream()
                                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                    .entrySet().stream().max((o1, o2) -> o1.getValue().compareTo(o2.getValue()))
                                    .map(Map.Entry::getKey).orElse(null);

    }
    
}
