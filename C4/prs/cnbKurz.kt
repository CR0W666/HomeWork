import java.io.File
import java.io.FileNotFoundException
import java.util.*
import java.util.regex.Pattern
import kotlin.system.exitProcess

object cnbKurz {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        val pattern = Pattern.compile("((^[0-9]*\\.[0-9]+)|(^[0-9]+))\\s[a-zA-Z]{3}+\\s[Tt][Oo]\\s[a-zA-Z]{3}+$")
        val rates = initAndWelcome()
        while (true) {
            val input = input(sc, pattern)
            if (input == "END") break
            val values = input.split(" ").toTypedArray()
            var rate1: ExchangeRate
            var rate2: ExchangeRate
            try {
                rate1 = getRateByName(values[1].uppercase(Locale.getDefault()), rates)
                rate2 = getRateByName(values[3].uppercase(Locale.getDefault()), rates)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
            val result = convert(values[0].toDouble(), rate1, rate2)
            println(values[0] + " " + rate1.code + " = " + result + " " + rate2.code)
        }
    }

    private fun getRateByName(name: String, rates: ArrayList<ExchangeRate>): ExchangeRate {
        for (exRate in rates) {
            if (exRate.code == name) return exRate
        }
        throw IllegalArgumentException("Neznamy Kurz")
    }

    @Throws(FileNotFoundException::class)
    fun initRates(): ArrayList<ExchangeRate> {
        val rates = ArrayList<ExchangeRate>()
        Scanner(File(cnbKurz::class.java.getResource("kurzy.txt").file)).use { fileRead ->
            var cnt = 0
            while (fileRead.hasNext()) {
                cnt++
                if (cnt < 3) {
                    fileRead.nextLine()
                    continue
                }
                val values = fileRead.nextLine().split("\\|").toTypedArray()
                rates.add(
                    ExchangeRate(
                        values[0],
                        values[1],
                        values[2],
                        values[3],
                        values[4].replace(",", ".")
                    )
                )
            }
        }
        return rates
    }

    private fun initAndWelcome(): ArrayList<ExchangeRate> {
        var rates: ArrayList<ExchangeRate>
        try {
            rates = initRates()
        } catch (e: FileNotFoundException) {
            println("Soubor s kurzy nebyl nalezen. Pridejte soubor s kurzy do stejneho adresare jako program s nazvem \"kurzy.txt\"")

            exitProcess(0)
        }
        println("----------------\nDostupne Kurzy:")
        for (rate in rates) print(rate.code + " | ")
        println("\nZadejte kurz ke konverzi ve formatu {POCET} {MENA} TO {MENA2}\nEq.: 100 EUR TO JPY")
        println("----------------")
        return rates
    }

    private fun input(sc: Scanner, pattern: Pattern): String {
        var input: String
        while (true) {
            println("Zadejte parametry (END pro konec)")
            input = sc.nextLine()
            if (pattern.matcher(input)
                    .matches() || input == "END"
            ) return input else println("Neplatny format.\nSpravny format: {POCET} {MENA} TO {MENA2}\nEq.: 100 EUR TO JPY")
        }
    }

    private fun convert(amount: Double, exR1: ExchangeRate, exR2: ExchangeRate): Double {
        return amount * (exR1.rate / exR1.amount) / (exR2.rate / exR2.amount)
    }
}

class ExchangeRate(var country: String, var name: String, amount: String?, code: String, rate: String?) {
    var amount: Double
    var code: String
    var rate: Double

    init {
        this.amount = java.lang.Double.valueOf(amount)
        this.code = code
        this.rate = java.lang.Double.valueOf(rate)
    }
}
