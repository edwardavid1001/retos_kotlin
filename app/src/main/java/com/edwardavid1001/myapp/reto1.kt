package com.edwardavid1001.myapp

class reto1 {
}

class CrapsGame {
}

fun main() {

    println("¡BIENVENIDO AL DESAFÍO DE CRAPS!")
    println("Debes lograr uno de los siguientes resultados para ganar:")
    println("1. Obtener un par de unos en los dados.")
    println("2. Alcanzar un total de tres puntos en los dados.")
    println("3. Sumar once puntos en ambos dados.")
    println("4. Obtener un total de dos o doce puntos en los dados.")
    println("5. Alcanzar un total de siete puntos en los dados.")
    println("---------------------------------")

    var dice1: Int = (1..6).random()
    println("¡Tu primer lanzamiento dio como resultado $dice1 puntos!")
    var dice2: Int = (1..6).random()
    println("¡Tu segundo lanzamiento dio como resultado $dice2 puntos!")

    if ((dice1 == 1 && dice2 == 1) || (dice1 == 2 && dice2 == 1) || (dice1 == 1 && dice2 == 2) ||
        (dice1 == 5 && dice2 == 6) || (dice1 == 6 && dice2 == 5) || (dice1 == 6 && dice2 == 6) ||
        (dice1 == 5 && dice2 == 2) || (dice1 == 2 && dice2 == 5) || (dice1 == 6 && dice2 == 1) ||
        (dice1 == 1 && dice2 == 6) || (dice1 == 4 && dice2 == 3) || (dice1 == 3 && dice2 == 4)
    ) {
        print("¡Felicidades, has ganado!")
    } else {
        print("Lo siento, has perdido. ¡Inténtalo de nuevo!")
    }
}
