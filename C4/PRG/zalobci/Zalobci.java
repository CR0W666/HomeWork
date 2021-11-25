package zalobci;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
* Zpracujte soubor naklady_zastoupeni.csv (nebo můžete mít nahardcoděno v aplikaci).
* V něm jsou 3 údaje - rok, jméno a částka.
* Každý řádek vhodně reprezentujte třídou a uložte do kolekce..
! 1. Spočítejte průměrnou částku sporu (zaokrouhlenou na celé 100 koruny, inflaci ignorujme).
! 2. Spočítejte, který žalobce "stál" celkově nejvíc. (Tj. součet částek všech jeho sporů), a kolik byla jeho celková "cena"
*/

public class Zalobci {
    public static void main(String[] args) throws FileNotFoundException {
        final List<Disputee> disputes = initDisputes();
        final double totalAvg = avgDisputeCosts(disputes);
        final Disputee mostExpensiveDisputee = mostExpensiveDisputee(groupByName(disputes));
        System.out.println(totalAvg + " | " + Math.floor(totalAvg/100) + " Stovek");
        System.out.println("Nejdrazsi spor je od " + mostExpensiveDisputee.name + ": " + mostExpensiveDisputee.cost + "kc");
    }


    public static List<Disputee> initDisputes() throws FileNotFoundException {
        List<Disputee> disputes = new ArrayList<>();
        
        Scanner sc = new Scanner(new File("C4\\PRG\\zalobci\\naklady_zastoupeni.csv"));
        sc.nextLine(); //Skip header
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(",");
            line[2] = line[2].replace(".00", "");
            
            // !hrozne dirty
            if(line[2].contains("Finspel")) {
                line[1] += "," + line[2];
                line[2] = line[3].replace(".00", "");
            }

            disputes.add(new Disputee(line[0], line[1], Long.parseLong(line[2])));

        }



        return disputes;
    }

    public static Map<String, Long> groupByName(List<Disputee> disputes) {
        
        Map<String, Long> grouped = new HashMap<>();
        
        for (Disputee dispute : disputes) {
            if(grouped.containsKey(dispute.name)) 
                grouped.put(dispute.name, grouped.get(dispute.name) + dispute.cost);
            else 
                grouped.put(dispute.name, dispute.cost);
        }


        return grouped;
    }

    public static Disputee mostExpensiveDisputee(Map<String, Long> disputees) {
        Map.Entry<String, Long> mostExpensiveDisputee = disputees.entrySet()
                                                                 .stream()
                                                                 .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get();
        String name = mostExpensiveDisputee.getKey();
        Long cost = mostExpensiveDisputee.getValue();

        return new Disputee("null", name, cost);
    }
    public static double avgDisputeCosts(List<Disputee> disputes) {
        long sum = 0;
        for (Disputee disputee : disputes) {
            sum += disputee.cost;
        }
        
        return ((double) sum / disputes.size());
    } 

}
