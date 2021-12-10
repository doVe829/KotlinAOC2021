package aoc2021

import aoc2021.helper.fileToList

fun main() {
    val input = fileToList("src/aoc2021/Day08_input.txt")

    // map of number with needed lights
    var connectionMap = mutableMapOf(
        0 to 6,
        1 to 2,
        2 to 5,
        3 to 5,
        4 to 4,
        5 to 5,
        6 to 6,
        7 to 3,
        8 to 7,
        9 to 6
    )

    fun uniqueNumbers(): List<Int> {
        val countLights = connectionMap.values.toList().groupingBy { it }.eachCount()
        val uniqueLightsValues = countLights.filter { (_, value) -> value === 1 }

        return uniqueLightsValues.keys.toList()
    }

    fun partOne(input: List<String>): Int {
        var count = 0
        input.forEach { inp ->
            val splitValuesAndInput = inp.split("|")
            val inputs = splitValuesAndInput[1].split(" ").filter { it.isNotEmpty() }
            val countOfLetters = inputs.map { it.count() }
            countOfLetters.forEach { letter ->
                uniqueNumbers().forEach { number ->
                    if (letter == number) {
                        count++
                    }
                }
            }
        }
        return count
    }

    println(partOne(input))

}