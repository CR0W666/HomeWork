package zalobci;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Zpracujte soubor naklady_zastoupeni.csv (nebo můžete mít nahardcoděno v aplikaci). V něm jsou 3
 * údaje - rok, jméno a částka. Každý řádek vhodně reprezentujte třídou a uložte do kolekce.. ! 1.
 * Spočítejte průměrnou částku sporu (zaokrouhlenou na celé 100 koruny, inflaci ignorujme). ! 2.
 * Spočítejte, který žalobce "stál" celkově nejvíc. (Tj. součet částek všech jeho sporů), a kolik
 * byla jeho celková "cena"
 */

public class Zalobci {
    public static void main(String[] args) throws FileNotFoundException {
        final List<Disputee> disputes = initDisputes();
        
        final double totalAvg = avgDisputeCosts(disputes);
        System.out.println("Prumerna castka sporu: " + Math.floor(totalAvg / 100) + " Stovek (" + Math.round(totalAvg) + "kc)");

        final Disputee mostExpensiveDisputee = mostExpensiveDisputee(groupByName(disputes));
        final String name = mostExpensiveDisputee.name;
        final Long cost = mostExpensiveDisputee.cost;
        System.out.println("Nejdrazsi spor je od " + name + ": " + cost + "kc");
    }


    public static List<Disputee> initDisputes() throws FileNotFoundException {
        final List<Disputee> disputes = new ArrayList<>();

        final Scanner sc = new Scanner(new File("C4\\PRG\\zalobci\\naklady_zastoupeni.csv"));
        sc.nextLine(); // Skip header

        while (sc.hasNext()) {
            final String[] line = sc.nextLine().split(",");

            if(line.length > 2) {
                for(int i = 2; i <= line.length-2; i++) line[1] += "," + line[i];
            }
            

            disputes.add(new Disputee(line[0], line[1], Long.parseLong(line[line.length-1].replace(".00", ""))));

        }



        return disputes;
    }

    public static Map<String, Long> groupByName(List<Disputee> disputes) {

        final Map<String, Long> grouped = new HashMap<>();

        for (Disputee dispute : disputes) {
            if (grouped.containsKey(dispute.name))
                grouped.put(dispute.name, grouped.get(dispute.name) + dispute.cost);
            else
                grouped.put(dispute.name, dispute.cost);
        }

        return grouped;
    }

    public static Disputee mostExpensiveDisputee(Map<String, Long> disputees) {
        final Map.Entry<String, Long> mostExpensiveDisputee = disputees.entrySet().stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get();
        final String name = mostExpensiveDisputee.getKey();
        final Long cost = mostExpensiveDisputee.getValue();

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
