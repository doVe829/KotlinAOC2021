package aoc2021.helper

import java.io.File

fun fileToIntList(pathName: String): List<Int> {
    return File(pathName).readLines().map { it.toInt() }
}

fun fileToList(pathName: String): List<String> {
    return File(pathName).readLines()
}