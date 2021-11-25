package zalobci;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
*Zpracujte soubor naklady_zastoupeni.csv (nebo můžete mít nahardcoděno v aplikaci).
! V něm jsou 3 údaje - rok, jméno a částka.
*Každý řádek vhodně reprezentujte třídou a uložte do kolekce..

1. Spočítejte průměrnou částku sporu (zaokrouhlenou na celé 100 koruny, inflaci ignorujme).
2. Spočítejte, který žalobce "stál" celkově nejvíc. 
(Tj. součet částek všech jeho sporů), a kolik byla jeho celková "cena"
*/


public class Zalobci {
    public static void main(String[] args) throws FileNotFoundException {
        List<Zalobce> disputes = new ArrayList<>();

        try (Scanner sc = new Scanner(new File("./naklady_zastoupeni.csv"))) {
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");
                disputes.add(new Zalobce(line[0], line[1], Double.parseDouble(line[2])));
            }

        } catch (Exception e) {
            System.out.println("Neplatny vstup");
        }

        
    }
}
