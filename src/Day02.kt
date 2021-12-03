package day2
import helper.fileToList

val input = fileToList("src/Day02_input.txt")
/* down X increases your aim by X units.
up X decreases your aim by X units.
forward X does two things:
It increases your horizontal position by X units.
It increases your depth by your aim multiplied by X. */

fun partTwo(){
    var xPosition = 0
    var yPosition = 0
    var aim = 0
    input.forEach { element ->
        var splitted = element.split(" ")
        var key = splitted[0]
        var value = splitted[1].toInt()
        if(key == "forward"){
            xPosition += value
            yPosition += aim * value
        }

        if (key == "down"){
            aim += value
        }

        if (key == "up"){
            aim -= value
        }
    }

    println("x = $xPosition , y = $yPosition")
    println(xPosition * yPosition);
}

fun partOne(){
    var xPosition = 0
    var yPosition = 0

    input.forEach { element ->
        var splitted = element.split(" ")
        var key = splitted[0]
        var value = splitted[1].toInt()
        if(key == "forward"){
            xPosition += value
        }

        if (key == "down"){
            yPosition += value
        }

        if (key == "up"){
            yPosition -= value
        }
    }

    println("x = $xPosition , y = $yPosition")
    println(xPosition * yPosition);
}

fun main(){
    partOne()
    partTwo()
}
