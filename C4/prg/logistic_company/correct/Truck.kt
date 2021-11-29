package prg.logistic_company.correct

class Truck(private val maxWeight: Double, private var currentWeight: Double = 0.0) : Car(maxWeight, currentWeight) {

    public fun load(loadMass: Double) {
        this.weight += loadMass
    }
}