package aoc2021.day3

import aoc2021.helper.fileToList

val input = fileToList("src/aoc2021/Day03_input.txt")
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
    var bit:String
    val list = arrayListOf<Char>()
    input.forEach{ inp ->
        list.add(inp[position])
    }
    val listSums = list.groupingBy { it }.eachCount()
    bit = listSums.maxByOrNull { it.value }?.key.toString()
    return bit
}


fun List<String>.countBits(index: Int): Pair<Int, Int> {
    var zeros = 0
    var ones = 0
    this.forEach {
        when (it[index]) {
            '0' -> zeros++
            '1' -> ones++
        }
    }
    return zeros to ones
}
fun part2(input: List<String>): Int {
    // length of string
    val length = input.first().length

    // put all inputs in to array
    var oxygen = input.map { it }
    println(oxygen)
    var i = 0
    while (oxygen.size > 1) {
        val (zeros, ones) = oxygen.countBits(i)
        oxygen = oxygen.filter { it[i] == if (zeros > ones) '0' else '1' }
        i = (i + 1) % length
    }

    var co2 = input.map { it }
    i = 0
    while (co2.size > 1) {
        val (zeros, ones) = co2.countBits(i)
        co2 = co2.filter { it[i] == if (zeros <= ones) '0' else '1' }
        i = (i + 1) % length
    }

    return oxygen.first().toInt(2) * co2.first().toInt(2)
}


fun main(){
    println(part2(input))

    // PART ONE //
    var gammaRate = ""

    for (bit in bitIndices){
        gammaRate += findBit(bit)
    }
    var gammaRateDecimal = convertBinaryToDecimal(gammaRate.toLong())
    println("Gamma as decimal: $gammaRateDecimal")
    var epsilonRate = gammaRate.replace("0", "a").replace("1", "b")
        .replace("a", "1").replace("b", "0")
    var epsilonRateDecimal = convertBinaryToDecimal(epsilonRate.toLong())
    println("Epsilon as decimal: $epsilonRateDecimal")
    println("Solution: " + gammaRateDecimal * epsilonRateDecimal)
    // ####################################################### //


}
