package ovoce_zelenina;

import java.util.Scanner;

class OvoceZelenina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] zelenina = createArray(sc, "zelenin");
        String[] ovoce = createArray(sc, "ovoce");

        System.out.println("Zadej co chces identifikovat.\n");
        String identify = sc.nextLine();
        sc.close();
        System.out.println(identify + " je " + identifyObject(identify, ovoce, zelenina));

    }

    public static String[] createArray(Scanner sc, String type) {
        System.out.printf("Zadej pocet %s.%n", type);
        if (type.equals("zelenin"))
            type += "u";
        String[] arr = new String[sc.nextInt()];
        sc.reset();
        for (int i = 0; i < arr.length + 1; i++) {
            System.out.printf("Zadej %d. %s%n", i, type);
            arr[i - 1] = sc.nextLine().toUpperCase();
        }
        return arr;
    }

    public static boolean lookingFor(String desired, String[] array) {
        for (String object : array) {
            if (object.equals(desired.toUpperCase()))
                return true;
        }
        return false;
    }

    public static String identifyObject(String identify, String[] ovoce, String[] zelenina) {
        if (lookingFor(identify, zelenina))
            return "zelenina";
        else if (lookingFor(identify, ovoce))
            return "ovoce";
        else
            return "ostatni";
    }



}
