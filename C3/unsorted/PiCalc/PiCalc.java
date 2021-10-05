import java.math.BigDecimal;

class PiCalc {
    public static void main(String[] args) {
        
        BigDecimal pi = new BigDecimal("0");
        BigDecimal tmpi = new BigDecimal("0");
        BigDecimal check = new BigDecimal("0");
        BigDecimal checktemp = new BigDecimal("0");
        BigDecimal rekordpi = new BigDecimal("0");
        BigDecimal oficpi = new BigDecimal("3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862");
        long i = 0;

        for (;; i++) {

            pi = pi.add(BigDecimal.valueOf(Math.pow(-1, i) / (2 * i + 1)));

            tmpi = pi.multiply(BigDecimal.valueOf(4));

            check = oficpi.subtract(tmpi);
            if (check.compareTo(checktemp) < 0) {
                rekordpi = tmpi;
                System.out.print("\r" + i + " | " + rekordpi);
            }
            checktemp = check;

        }
    }
}