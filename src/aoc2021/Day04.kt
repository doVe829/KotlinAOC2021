package aoc2021.day4

import aoc2021.helper.fileToList
val input = fileToList("src/aoc2021/Day04_input.txt")

fun main(){
    println(part1())
    println(part2())

}

fun part1(): Int{
    val (inputs, boards) = createBoardAndInputs(input)
    return playBingo(numbers = inputs, boards = boards )

}

fun part2(): Int{
    val (inputs, boards) = createBoardAndInputs(input)
    return playBingo(numbers = inputs, boards = boards, firstFound = false )
}

fun playBingo(
    boards: List<List<MutableList<Int>>>,
    numbers: List<Int>,
    firstFound: Boolean = true
): Int {
    val boardBingo = BooleanArray(boards.size)
    var bingoLeft = boards.size
    var hasZero = false

    numbers.forEach { number ->
        if (number == 0) hasZero = true
        boards.forEachIndexed { index, board ->
            if (boardBingo[index]) return@forEachIndexed

            board.forEach { row ->
                row.forEachIndexed { index, value ->
                    if (value == number) {
                        row[index] *= -1
                    }
                }
            }
            val (bingo, sum) = board.checkBoard(hasZero)
            if (bingo) {
                boardBingo[index] = bingo
                if (firstFound || --bingoLeft == 0) {
                    return sum * number
                }
            }
        }
    }

    return 0
}

fun createBoardAndInputs(input:List<String>): Pair<List<Int>, List<List<MutableList<Int>>>> {
    val gameInputs = input.first().split(",").map { it.toInt() }

    val gameLines = input.drop(1).filter { it.isNotEmpty() }
    val boards = gameLines.windowed(5, 5).map { it ->
        it.map { row ->
            row.split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toMutableList()
        }.toMutableList()
    }.toMutableList()

    return gameInputs to boards
}

fun List<List<Int>>.sumBoard(): Int {
    return sumOf { it.filter { it > 0 }.sum() }
}

fun List<List<Int>>.checkBoard(hasZero: Boolean): Pair<Boolean, Int> {
    for (row in indices) {
        val bingo = this[row].all { if (hasZero) it <= 0 else it < 0 }
        if (bingo) return Pair(true, sumBoard())
    }

    for (col in this[0].indices) {
        val bingo = all { if (hasZero) it[col] <= 0 else it[col] < 0 }
        if (bingo) return Pair(true, sumBoard())
    }

    return false to 0
}