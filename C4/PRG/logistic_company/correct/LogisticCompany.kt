package logistic_company.correct

class LogisticCompany {

    fun main() {
        
        val truck = Truck(0, 60.0)
        println(truck.weight)
        truck.load(20.0)
        println(truck.weight)
        truck.unload(20.0)
        println(truck.weight)
    }
}

    



