package day3

import helper.fileToList

val input = fileToList("src/Day03_input.txt")
val bitIndices = input[0].indices


fun main(){
    input.forEach {  el ->
        println(el[0])

    }

}
