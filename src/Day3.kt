package day3

import helper.fileToList

val input = fileToList("src/Day03_input.txt")
val bitIndices = input[0].indices

fun convertBinaryToDecimal(num: Long): Int {
    var num = num
    var decimalNumber = 0
    var i = 0
    var remainder: Long

    while (num.toInt() != 0) {
        remainder = num % 10
        num /= 10
        decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
        ++i
    }
    return decimalNumber
}

fun findBit(position: Int) : String{
    var bit = ""
    val list = arrayListOf<Char>()
    input.forEach{ inp ->
        list.add(inp[position])
    }
    val listSums = list.groupingBy { it }.eachCount()
    bit = listSums.maxByOrNull { it.value }?.key.toString()
    return bit


}


fun main(){
    // PART ONE //
    var gammaRate = ""

    for (bit in bitIndices){
        gammaRate += findBit(bit)
    }
    var gammaRateDecimal = convertBinaryToDecimal(gammaRate.toLong())
    println("Gamma as decimal: $gammaRateDecimal")
    var epsilonRate = gammaRate.replace("0", "a").replace("1", "b").replace("a", "1").replace("b", "0")
    var epsilonRateDecimal = convertBinaryToDecimal(epsilonRate.toLong())
    println("Epsilon as decimal: $epsilonRateDecimal")
    println("Solution: " + gammaRateDecimal*epsilonRateDecimal)
    // ####################################################### //


}
