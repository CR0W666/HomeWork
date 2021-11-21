package logistic_company.correct

class Truck(val idx: Int, val maxWeight: Double, var currentWeight: Double = 0.0) : Car(idx, maxWeight, currentWeight) {

    public fun load(loadMass: Double) {
        this.weight = loadMass
    }

    public fun unload(loadMass: Double) {
        this.weight = -loadMass
    }
}