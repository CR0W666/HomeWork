package logistic_company.correct

open class Car(val _id: Int, val _carryWeight: Double, var _weight: Double = 0.0) {

    val id: Int
        get() { return field }

    val carryWeight: Double
        get() { return field }

    var weight: Double = 0.0
        get() { return field }

        set(value) {
            field += value
        }

    init {
        id = _id
        carryWeight = _carryWeight
        weight = _weight
    }
    
}