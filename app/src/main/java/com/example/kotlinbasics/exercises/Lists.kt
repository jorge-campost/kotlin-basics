package com.example.kotlinbasics.exercises

fun main() {
    println("LISTAS")

    val readOnly: List<String> =
        listOf("lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo");


    val filtered = readOnly.filter { day -> day.contains("a") }

    filtered.forEach { println(it) }

    var weekDays: MutableList<String> = mutableListOf("lunes", "martes", "miércoles", "jueves")
    weekDays.add("viernes")
    println(weekDays)

}