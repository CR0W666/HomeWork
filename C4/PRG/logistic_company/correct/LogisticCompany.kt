package logistic_company.correct

import Truck

class LogisticCompany {

    fun main() {
        println("Zadejte nosnost aut \nJednotliva auta rozdelte mezerou: 50 62.3 84")
        val trucks: Truck = readLine()!!.split("\\s".toRegex()).forEach { maxWeight -> 
            Truck(maxWeight, 0.0)
        }
        println(trucks.toString())
    }
}