package C4.prg.cnb_two;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * cnbKurz
 * 
 * Zpracujte dnešní kurzy od ČNB - můžete mít uložené jako string v programu. Uživatel bude zadávat
 * konverzi ve formátu {POČET} {MĚNA 1} TO {MĚNA 2}. Program vypíše počet druhé měny dle denního
 * kurzu. Program by měl počítat i s tím, že kurzy pro dané měny nezná - v tom případě vypíše
 * adekvátní uživatelskou hlášku. Program běží, dokud uživatel "nevypne" vstup.
 *
 *
 * Vypnutí vstupu nechám na Vás - můžete použít hasNext a Ctrl+D pro vypnutí nebo kontrolu vstupu na
 * ukončovací hlášku.
 */
public class CnbKurz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile(
                "((^[0-9]*\\.[0-9]+)|(^[0-9]+))\\s[a-zA-Z]{3}+\\s[Tt][Oo]\\s[a-zA-Z]{3}+$");
        List<ExchangeRate> rates = initAndWelcome();

        String input = "";
        while (!input.equals("END")) {
            input = input(sc, pattern);
            String[] values = input.split(" ");
            ExchangeRate rate1;
            ExchangeRate rate2;
            try {
                rate1 = getRateByName(values[1].toUpperCase(), rates);
                rate2 = getRateByName(values[3].toUpperCase(), rates);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            double result = convert(Double.parseDouble(values[0]), rate1, rate2);
            System.out.println(values[0] + " " + rate1.code + " = " + result + " " + rate2.code);
        }

    }

    public static ExchangeRate getRateByName(String name, List<ExchangeRate> rates) {
        for (ExchangeRate exRate : rates) {
            if (exRate.getCode().equals(name))
                return exRate;
        }
        throw new IllegalArgumentException("Neznamy Kurz");
    }

    public static List<ExchangeRate> initRates() throws FileNotFoundException {
        ArrayList<ExchangeRate> rates = new ArrayList<>();
        try (Scanner fileRead =
                new Scanner(new File(CnbKurz.class.getResource("kurzy.txt").getFile()))) {
            int cnt = 0;
            while (fileRead.hasNext()) {
                cnt++;
                if (cnt < 3) {
                    fileRead.nextLine();
                    continue;
                }
                String[] values = fileRead.nextLine().split("\\|");
                rates.add(new ExchangeRate(values[0], values[1], values[2], values[3],
                        values[4].replace(",", ".")));
            }
        }

        return rates;
    }

    public static List<ExchangeRate> initAndWelcome() {
        List<ExchangeRate> rates;
        try {
            rates = initRates();
        } catch (FileNotFoundException e) {
            System.out.println(
                    "Soubor s kurzy nebyl nalezen. Pridejte soubor s kurzy do stejneho adresare jako program s nazvem \"kurzy.txt\"");
            rates = new ArrayList<>();
            System.exit(0);
        }

        System.out.println("----------------\nDostupne Kurzy:");
        for (ExchangeRate rate : rates)
            System.out.print(rate.code + " | ");
        System.out.println(
                "\nZadejte kurz ke konverzi ve formatu {POCET} {MENA} TO {MENA2}\nEq.: 100 EUR TO JPY");
        System.out.println("----------------");

        return rates;
    }

    public static String input(Scanner sc, Pattern pattern) {
        String input;
        while (true) {
            System.out.println("Zadejte parametry (END pro konec)");
            input = sc.nextLine();
            if (pattern.matcher(input).matches() || input.equals("END"))
                return input;
            else
                System.out.println(
                        "Neplatny format.\nSpravny format: {POCET} {MENA} TO {MENA2}\nEq.: 100 EUR TO JPY");
        }
    }

    public static double convert(double amount, ExchangeRate exR1, ExchangeRate exR2) {
        return (amount * (exR1.rate / exR1.amount)) / (exR2.rate / exR2.amount);
    }
}

