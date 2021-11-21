package codeforces_one_a;

public class CodeForces1A {

    /**
     * @param args
     */
    public static void main(String[] args) {
        test();
    }


    /**
     * @param n
     * @param m
     * @param a
     * @return int
     */
    public static int calculateFlagstones(double n, double m, double a) {
        return (int) (Math.ceil(n / a) + Math.ceil(m / a));
    }

    public static void test() {
        System.out.printf("6 6 4: %s%n", calculateFlagstones(6, 6, 4));
    }
}
