package CodeForces550A;

public class CodeForces550A {
    public static void main(String[] args) {
        test();
    }

    public static boolean validateString(String input) {
        input = input.toUpperCase();
        if (!input.contains("AB") || !input.contains("BA"))
            return false; // if it does not contain the substrings, guard false
        int[] abidx = new int[2];
        int[] baidx = new int[2];

        for (int i = 0; i < input.length(); i++) {
            if(i+1 < input.length()) {
                if (input.charAt(i) == 'A' && input.charAt(i + 1) == 'B') {
                    abidx[0] = i;
                    abidx[1] = i + 1;
                }
                if (input.charAt(i) == 'B' && input.charAt(i + 1) == 'A') {
                    baidx[0] = i;
                    baidx[1] = i + 1;
                }
            } else break;
        }

        if (abidx[0] == baidx[1] || abidx[1] == baidx[0])
            return false;

        return true;
    }

    public static void test() {
        System.out.printf("ABA: %s\n", validateString("ABA"));
        System.out.printf("BACFAB: %s\n", validateString("BACFAB"));
        System.out.printf("AXBYBXA: %s\n", validateString("AXBYBXA"));
    }
}
