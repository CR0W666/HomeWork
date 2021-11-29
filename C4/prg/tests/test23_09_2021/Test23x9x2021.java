package tests.test23_09_2021;

class Test23x9x2021 {
    public static void main(String[] args) {
        test();
    }

    public static boolean validateString(String input) {
        input = input.toUpperCase();
        if (!input.contains("AB") || !input.contains("BA"))
            return false;
        int[] abidx = new int[2];
        int[] baidx = new int[2];


        for (int i = 0; i < input.length(); i++) {

            if (i + 1 < input.length()) {
                if (!(abidx[0] != 0 && abidx[1] != 0) && !(baidx[0] != 0 && baidx[1] != 0)) {
                    if (input.charAt(i) == 'A' && input.charAt(i + 1) == 'B') {
                        abidx[0] = i;
                        abidx[1] = i + 1;
                    }
                    if (input.charAt(i) == 'B' && input.charAt(i + 1) == 'A') {
                        baidx[0] = i;
                        baidx[1] = i + 1;
                    }
                }
            } else
                break;
        }
        return !(abidx[0] == baidx[1] || abidx[1] == baidx[0]);
    }

    public static void test() {
        System.out.printf("ABA: %s%n", validateString("ABA"));
        System.out.printf("ABBA: %s%n", validateString("ABBA"));
        System.out.printf("BABA: %s%n", validateString("BABA"));
        System.out.printf("BANAN: %s%n", validateString("BANAN"));
        System.out.printf("BAB: %s%n", validateString("BAB"));
        System.out.printf("KABAT: %s%n", validateString("KABAT"));
        System.out.printf("ZABOBA: %s%n", validateString("ZABOBA"));
        System.out.printf("OBANABI: %s%n", validateString("OBANABI"));
        System.out.printf("OBAMA: %s%n", validateString("OBAMA"));
        System.out.printf("OBIWAN KENOBI: %s%n", validateString("OBIWAN KENOBI"));
        System.out.printf("*null*: %s%n", validateString(""));
        System.out.printf("ABBAABBAABABBABA: %s%n", validateString("ABBAABBAABABBABA"));
    }
}
