package prg.logistic_company.correct

class LogisticCompany {

    fun main() {
        println("Zadejte nosnost aut \nJednotliva auta rozdelte mezerou: 50 62.3 84")
        val trucks = readLine()!!.split("\\s".toRegex()).forEach { maxWeight ->
            Truck(maxWeight.toDouble(), 0.0)
        }
        //val trucks = Truck(60.0, 0.0)
        println(trucks.toString())
    }
}