package logistic_company.retarded;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LogisticCompanyRetarded {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            while(true) {
                try {
                    System.out.println("Zadejte nosnost aut \nJednotliva auta rozdelte mezerou: 50 62.3 84");
                    List<Car> cars = Arrays.asList((sc.nextLine().split(" ")))
                                           .stream()
                                           .collect(HashMap::new, (idx, val) -> idx.put(idx.size(), val), (idx, val2) -> {})
                                           .entrySet()
                                           .stream()
                                           .map(val -> new Car(Integer.valueOf(val.getKey().toString()),
                                                                 Double.valueOf(val.getValue().toString()), 
                                                                 0.0))
                                           .toList();
        
                    while (true) {
                        System.out.println(
                                "Zadejte cislo auta a mezerou oddelte kolik chcete nalozit/vylozit. (6 -30) \"END\" pro konec");

                        String input = sc.nextLine();
                        if (input.equals("END"))
                            break;
                        loadingAndUnloading(cars, input);
                    }

                    System.out.println("Prumerna Vaha: "
                            + cars.stream().mapToDouble(Car::getWeight).average().getAsDouble());

                } catch (Exception e) {
                    System.out.println("Neplatny vstup, chcete ukoncit program? y/n");
                    if (sc.nextLine().equalsIgnoreCase("Y"))
                        break;
                }
            }
        }  
    }

    private static void loadingAndUnloading(List<Car> cars, String input) {
        try {
            String[] idAndWeight = input.split(" ");
            cars.stream().takeWhile(car -> Integer.parseInt(idAndWeight[0]) < (car.getId() + 1)
                    || Integer.parseInt(idAndWeight[1]) >= 0).forEach(car -> {
                        int inputID = Integer.parseInt(idAndWeight[0]);
                        double inputChange = Double.parseDouble(idAndWeight[1]);
                        if ((car.getId() + 1) == inputID) {
                            if ((car.getWeight() + inputChange) > 0
                                    && (car.getWeight() + inputChange <= car.getCarryWeight()))
                                car.setWeight(car.getWeight() + inputChange);
                        } else
                            System.out.println("Neplatna vaha");
                    });

        } catch (NumberFormatException e) {
            System.out.println("Neplatny vstup");
        }
    }
}

