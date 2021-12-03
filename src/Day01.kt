package day1
import helper.fileToIntList
import java.io.File

val input = fileToIntList("src/Day01_input.txt")

fun partOne(){
    val pairs = input.windowed(2);
    print( pairs.count{ (a, b) -> a < b })
}

fun partTwo(){
    print(input.windowed(4).count { it[0] < it[3] })
    /*var counter = 0;
    var lastSum = 0;
    val triplets = input.windowed(3);
    for(triple in triplets){
        var currSum = triple.sum();
        if(currSum > lastSum){
            lastSum = currSum
            counter++
        }
    }
    println(counter - 1) */
}

fun main() {
    partTwo()
}