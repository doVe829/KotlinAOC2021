package aoc2021

import aoc2021.helper.fileToList
import kotlin.math.absoluteValue

fun main(){
    val input = fileToList("src/aoc2021/Day07_input.txt")
    val modifiedInput = input.single().split(",").map { it.toInt() }
    val lowestPosition = modifiedInput.minOrNull() ?: 0
    val highestPosition = modifiedInput.maxOrNull() ?: 0
    val range = lowestPosition .. highestPosition


    fun fuelBurned(allPositions: Int, extraSteps: Boolean = false): Int =
        modifiedInput.sumOf {
           val steps =  (allPositions - it).absoluteValue
            if (!(extraSteps)) steps else (steps * (steps + 1)) / 2

        }

    fun solution(extra: Boolean = false): Int{
        return range.map { fuelBurned(it, extra) }.minOf { it }
    }


    println(solution(true))
}


