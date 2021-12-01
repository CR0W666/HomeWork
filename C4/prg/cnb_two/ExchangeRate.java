package C4.prg.cnb_two;

class ExchangeRate {
    String country;
    String name;
    Double amount;
    String code;
    Double rate;

    ExchangeRate(String country, String name, String amount, String code, String rate) {
        this.country = country;
        this.name = name;
        this.amount = Double.valueOf(amount);
        this.code = code;
        this.rate = Double.valueOf(rate);
    }

    public Double getAmount() {
        return amount;
    }

    public String getCode() {
        return code;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public Double getRate() {
        return rate;
    }
}
