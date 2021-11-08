import java.util.*

object Snc {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            Scanner(System.`in`).use { sc ->
                val nums = getNums(sc)
                println("Sum of numbers bigger then the average of the total sum: " + sumAboveAvg(nums))
            }
        } catch (e: Exception) {
            println("Something has gone wrong, exiting program.\n$e")
        }
    }

    private fun getNums(sc: Scanner): ArrayList<Double> {
        val nums = ArrayList<Double>()
        println("Enter numbers eq.: 1 or 1,5. To finish press Ctrl+D")
        try {
            while (sc.hasNext()) {
                nums.add(sc.nextDouble())
            }
        } catch (e: Exception) {
            println(e)
        }
        return nums
    }

    private fun avg(nums: ArrayList<Double>): Double {
        return nums.stream().mapToDouble { d: Double? ->
            java.lang.Double.valueOf(
                d!!
            )
        }.average().orElseThrow()
    }

    private fun sumAboveAvg(nums: ArrayList<Double>): Double {
        val avg = avg(nums)
        var sum = 0.0
        for (num in nums) {
            if (num >= avg) sum += num
        }
        return sum
    }
}
