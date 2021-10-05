public class Fraction implements IFraction {

    private final Integer numerator;
    private final Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        if (denominator == 0) throw new ArithmeticException("Cannot Divide by 0");
    }

    @Override
    public Integer getNumerator() {
        return numerator;
    }

    @Override
    public Integer getDenominator() {
        return denominator;
    }

    @Override
    public IFraction plus(IFraction other) {
        
        int commonNum = (getNumerator() *  other.getDenominator()) + (other.getNumerator() * getDenominator());
        int commonDen = getDenominator() * other.getDenominator();

        return createNormalised(commonNum, commonDen);

    }

    @Override
    public IFraction minus(IFraction other) {
        
        int commonNum = (getNumerator() *  other.getDenominator()) - (other.getNumerator() * getDenominator());
        int commonDen = getDenominator() * other.getDenominator();

        return createNormalised(commonNum, commonDen);
    }

    @Override
    public IFraction times(IFraction other) {
        
        int commonNum = getNumerator() * other.getNumerator();
        int commonDen = getDenominator() * other.getDenominator();

        return createNormalised(commonNum, commonDen);
    }

    @Override
    public IFraction dividedBy(IFraction other) {
        
        int commonNum = getNumerator() * other.getDenominator();
        int commonDen = other.getNumerator() * getDenominator();

        return createNormalised(commonNum, commonDen);
    }

    public static Fraction createNormalised(Integer numerator, Integer denominator) {
        var gcd = getGcd(numerator, denominator);

        return new Fraction(numerator / gcd, denominator/ gcd);
    }

    public static int getEuclidGcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return  getEuclidGcd(num2, num1 % num2);
    }

    @Override
    public String toString() {
        return "Fraction " + numerator + "|" + denominator;
    }
}
