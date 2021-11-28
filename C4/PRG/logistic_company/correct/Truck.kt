package logistic_company.correct

import Car

class Truck(val maxWeight: Double, var currentWeight: Double = 0.0) : Car(maxWeight, currentWeight) {

    public fun load(loadMass: Double) {
        this.weight += loadMass
    }
}