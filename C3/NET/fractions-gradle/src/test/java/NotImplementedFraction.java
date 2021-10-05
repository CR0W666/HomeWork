public class NotImplementedFraction implements IFraction{

    private final int numerator;
    private final int denominator;

    public NotImplementedFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
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
        throw new UnsupportedOperationException();
    }

    @Override
    public IFraction minus(IFraction other) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IFraction times(IFraction other) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IFraction dividedBy(IFraction other) {
        throw new UnsupportedOperationException();
    }
}
