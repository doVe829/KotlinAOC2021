package aoc2021

import aoc2021.helper.fileToList

fun main() {
    var input = fileToList("src/aoc2021/Day06_input.txt")

    fun partOne(days: Int): Int {
        var startingFishes = input.single().split(",").map { it.toInt() }
        repeat(days) {
            val newFishes = ArrayList<Int>()
            startingFishes.forEach { fish ->
                if (fish > 0) {
                    newFishes.add(fish - 1)
                } else if (fish == 0) {
                    newFishes.add(6)
                    newFishes.add(8)
                }
            }
            startingFishes = newFishes

        }
        return startingFishes.size
    }


    fun partTwo() {
        var startingFishes = input.single().split(",").map { it.toInt() }
        var init = LongArray(9)
        startingFishes.forEach { init[it]++ }
        repeat(256) {
            val countdown = LongArray(9)
            for (lifeSpan in 0..8) {
                when {
                    lifeSpan > 0 -> countdown[lifeSpan - 1] += init[lifeSpan]
                    lifeSpan == 0 -> {
                        countdown[6] += init[lifeSpan]
                        countdown[8] += init[lifeSpan]
                    }
                }
            }
            init = countdown
        }
        println(init.sum())
    }

    println(partOne(80))
    partTwo()
}