object ArmstrongCorrect {
    @kotlin.jvm.JvmStatic
    fun main(args: Array<String>) {
        val input = input("enter a number \n")
        println("input is: $input")
        findArmstrongsUpTo(input)
    }

    fun input(msg: String?): Int {
        println(msg)
        try {
            java.util.Scanner(java.lang.System.`in`).use { sc -> return sc.nextInt() }
        } catch (e: InputMismatchException) {
            return 1000
        }
    }

    fun findArmstrongsUpTo(ceil: Int) {
        for (i in 1 until ceil) {
            if (isArmstrong(i)) println(i)
        }
    }

    fun isArmstrong(num: Int): Boolean {
        val digits: CharArray = num.toString().toCharArray()
        var sum = 0
        for (digit in digits) {
            val idigit: Int = java.lang.Character.getNumericValue(digit)
            sum += java.lang.Math.pow(idigit.toDouble(), digits.size.toDouble()).toInt()
        }
        return sum == num
    }
}
