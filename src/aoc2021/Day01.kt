package aoc2021.day1

import aoc2021.helper.fileToIntList

val input = fileToIntList("src/aoc2021/Day01_input.txt")


fun partOne() {
    val pairs = input.windowed(2);
    println(pairs.count { (a, b) -> a < b })
}

fun partTwo() {
    print(input.windowed(4).count { it[0] < it[3] })

}

fun main() {
    partOne()
    partTwo()
}