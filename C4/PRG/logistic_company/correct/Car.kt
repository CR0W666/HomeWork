package logistic_company.correct

open class Car(val _carryWeight: Double, var _weight: Double = 0.0) {

    val carryWeight: Double
        get() { return field }

    var weight: Double = 0.0
        get() { return field }

        set(value) {
            field += value
        }

    init {
        carryWeight = _carryWeight
        weight = _weight
    }
    
}