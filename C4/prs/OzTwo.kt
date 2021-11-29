package prs

import java.util.*

object OzTwo {
    @JvmStatic
    fun main(args: Array<String>) {

        // ------ PHASE ONE --------------
        val sc = Scanner(System.`in`)
        println("Zadej pocet zeleniny")
        val countZel = sc.nextInt()
        println("Zadej pocet ovoce")
        val countOvc = sc.nextInt()
        sc.nextLine()
        val zel = fillGroup("Zeleninu", countZel, sc)
        val ovc = fillGroup("Ovoce", countOvc, sc)

        // ------ PHASE TWO --------------
        checkType(zel, ovc, sc)

        // ------ PHASE THREE ------------
        printTypes(zel, ovc)
    }

    private fun fillGroup(group: String, size: Int, sc: Scanner): ArrayList<String> {
        val groupArr = ArrayList<String>()
        var i = 0
        while (i < size) {
            println("Zadej " + (i + 1) + ". " + group)
            val input = sc.nextLine()
            if (groupArr.contains(input)) {
                println("toto uz bylo zadano.")
                i--
            } else groupArr.add(input)
            i++
        }
        return groupArr
    }

    private fun checkType(zel: ArrayList<String>, ovc: ArrayList<String>, sc: Scanner) {
        var input: String
        println("Zadej neco co chces identifikovat. (\"END\" pro konec.) ")
        do {
            input = sc.nextLine()
            if (zel.contains(input) && ovc.contains(input)) println("Ovoce i Zelenina?") else if (zel.contains(input)) println(
                "Zelenina."
            ) else if (ovc.contains(input)) println("Ovoce.") else println("Ostatni.")
        } while (input != "END")
    }

    private fun printTypes(zel: ArrayList<String>, ovc: ArrayList<String>) {
        print("\nZelenina: ")
        for (z in zel) print("$z, ")
        print("\nOvoce: ")
        for (o in ovc) print("$o, ")
    }
}
