package AoC2021.day1
import AoC2021.helper.fileToIntList

val input = fileToIntList("src/2021/Day01_input.txt")


fun partOne(){
    val pairs = input.windowed(2);
    println( pairs.count{ (a, b) -> a < b })
}

fun partTwo(){
    print(input.windowed(4).count { it[0] < it[3] })

}

fun main() {
    partOne()
    partTwo()
}