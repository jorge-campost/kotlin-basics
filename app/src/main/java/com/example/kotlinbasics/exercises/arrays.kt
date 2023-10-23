package com.example.kotlinbasics.exercises

fun main() {
    println("hello world")

    var weekDays = arrayOf("lunes", "martes", "miércoles")
    println(weekDays.joinToString(" "))

    for (position in weekDays.indices) {
        println("posición: $position")
    }
    for ((index, value) in weekDays.withIndex()){
        println("$index - $value")
    }

    for (weekDay in weekDays){
        println(weekDay)
    }
}