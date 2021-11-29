package prg.logistic_company.correct

open class Car(private val _carryWeight: Double, private var _weight: Double = 0.0) {

    private val carryWeight: Double = _carryWeight

    var weight: Double = _weight
        set(value) {
            field += value
        }

}