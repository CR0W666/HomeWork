import kotlin.text.*
import Java.util.Scanner
import kotlin.math.ceil

object PoskozenyPrumer {
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val inputs = errorCorrection(inputSequence(sc))
        println("Corrected:")
        for (input in inputs) println(input)
    }

    private fun inputSequence(sc: Scanner): Array<String> {
        val inputs: Array<String>
        var counter = 0
        var input = ""
        while (sc.hasNext()) {
            input = sc.nextLine()
            if(input == "END") break
            inputs[0] = input
            counter++
        }
        return inputs
    }

    private fun errorCorrection(inputs: Array<String>): Array<String> {
        for (i in inputs.indicies) {

            if(!isNumeric(inputs[i])) {
                val sum = 0

                if(i >= 1) if(isNumeric(inputs[i-1])) sum += inputs[i-1].toInt()
                if(i >= 2) if(isNumeric(inputs[i-2])) sum += inputs[i-2].toInt()

                if(i <= (inputs.size-1)) if(isNumeric(inputs[i+1])) sum += inputs[i+1].toInt()
                if(i <= (inputs.size-2)) if(isNumeric(inputs[i+2])) sum += inputs[i+2].toInt()
                }
                inputs[i] = ceil(sum / 4).toPlainString()
            }
        }

        return inputs
    }

    fun isNumeric(input: String): Boolean = input
        .removePrefix("-")
        .removePrefix("+")
        .all { it in '0'..'9' }

}