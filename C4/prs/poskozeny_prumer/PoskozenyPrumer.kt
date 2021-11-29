import kotlin.text.*
import java.util.*
import kotlin.math.ceil

object PoskozenyPrumer {
    fun main() {
        val sc = Scanner(System.`in`)
        val inputs = errorCorrection(inputSequence(sc))
        println("Corrected:")
        for (input in inputs) println(input)
    }

    private fun inputSequence(sc: Scanner): Array<Any> {

        var input = ""
        while (sc.hasNext()) {
            input += sc.nextLine() + "|"
            if(input == "END") break
        }
        val inputs = input.split("|").stream().toArray()
        return inputs
    }

    private fun errorCorrection(_inputs: Array<Any>): Array<Any> {
        for (i in _inputs.indices) {
            var summ: Double = 0.0
            if (!isNumeric(_inputs[i] as String)) {

                if (i >= 1) if (isNumeric(_inputs[i - 1] as String)) summ += _inputs[i - 1] as Int
                if (i >= 2) if (isNumeric(_inputs[i - 2] as String)) summ += _inputs[i - 2] as Int

                if (i <= (_inputs.size - 1)) if (isNumeric(_inputs[i + 1] as String)) summ += _inputs[i + 1] as Int
                if (i <= (_inputs.size - 2)) if (isNumeric(_inputs[i + 2] as String)) summ += _inputs[i + 2] as Int
            }

            _inputs[i] = ceil(summ / 4).toString()
        }


        return _inputs
    }

    fun isNumeric(input: String): Boolean = input
        .removePrefix("-")
        .removePrefix("+")
        .all { it in '0'..'9' }

}