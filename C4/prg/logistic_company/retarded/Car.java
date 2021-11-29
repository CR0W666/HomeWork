package logistic_company.retarded;

public class Car {
    private int id;
    private double carryWeight;
    private double weight;

    public Car(int id, double carryWeight, double weight) {
        this.id = id;
        this.carryWeight = carryWeight;
        this.weight = weight;
    }

    public int getId() {
        return this.id;
    }

    public double getCarryWeight() {
        return this.carryWeight;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
