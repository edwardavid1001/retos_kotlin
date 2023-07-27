package com.edwardavid1001.myapp

class reto3 {
}

class Carro(val marca: String, val modelo: String, val año: Int)

fun main() {
    val listaCarros = mutableListOf<Carro>()
    var hayCarrosIngresados = false // Variable para verificar si se han ingresado carros

    do {
        println("=== Menú de opciones ===")
        println("1. Insertar nuevo carro")

        // Verificar si hay carros ingresados antes de mostrar las opciones 2, 3, 4 y 5
        if (hayCarrosIngresados) {
            println("2. Mostrar todos los carros")
            println("3. Buscar un carro por marca")
            println("4. Modificar un carro existente")
            println("5. Eliminar un carro existente")
        }

        println("6. Salir")

        print("Seleccione una opción: ")
        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> {
                val carro = crearCarroDesdeConsola()
                listaCarros.add(carro)
                hayCarrosIngresados = true // Actualizar la variable al ingresar un carro
                println("Carro agregado exitosamente.")
            }
            2 -> {
                if (hayCarrosIngresados) {
                    mostrarTodosLosCarros(listaCarros)
                } else {
                    println("No se ha ingresado ningún carro.")
                }
            }
            3 -> {
                if (hayCarrosIngresados) {
                    print("Ingrese la marca del carro a buscar: ")
                    val marcaBuscada = readLine()?.trim()
                    buscarCarrosPorMarca(listaCarros, marcaBuscada)
                } else {
                    println("No se ha ingresado ningún carro.")
                }
            }
            4 -> {
                if (hayCarrosIngresados) {
                    print("Ingrese la posición del carro a modificar (1-${listaCarros.size}): ")
                    val indiceCarroModificar = readLine()?.toIntOrNull()?.let { it - 1 }

                    if (indiceCarroModificar in 0 until listaCarros.size) {
                        val carroModificado = crearCarroDesdeConsola()
                        listaCarros[indiceCarroModificar!!] = carroModificado
                        println("El carro en la posición ${indiceCarroModificar + 1} ha sido modificado.")
                    } else {
                        println("Posición inválida. No existe un carro en la posición ${indiceCarroModificar?.let { it + 1 }}.")
                    }
                } else {
                    println("No se ha ingresado ningún carro.")
                }
            }
            5 -> {
                if (hayCarrosIngresados) {
                    print("Ingrese la posición del carro a eliminar (1-${listaCarros.size}): ")
                    val indiceCarroEliminar = readLine()?.toIntOrNull()?.let { it - 1 }

                    if (indiceCarroEliminar in 0 until listaCarros.size) {
                        listaCarros.removeAt(indiceCarroEliminar!!)
                        println("El carro en la posición ${indiceCarroEliminar + 1} ha sido eliminado.")

                        // Verificar si la lista está vacía después de eliminar un carro
                        if (listaCarros.isEmpty()) {
                            hayCarrosIngresados = false
                        }
                    } else {
                        println("Posición inválida. No existe un carro en la posición ${indiceCarroEliminar?.let { it + 1 }}.")
                    }
                } else {
                    println("No se ha ingresado ningún carro.")
                }
            }
            6 -> {
                println("Saliendo del programa...")
                break
            }
            else -> println("Opción inválida. Por favor, seleccione una opción válida.")
        }
        println()
    } while (true)
}

fun crearCarroDesdeConsola(): Carro {
    print("Ingrese la marca del carro: ")
    val marca = readLine()?.trim()

    print("Ingrese el modelo del carro: ")
    val modelo = readLine()?.trim()

    print("Ingrese el año del carro: ")
    val año = readLine()?.toIntOrNull() ?: 0

    return Carro(marca ?: "", modelo ?: "", año)
}

fun mostrarTodosLosCarros(listaCarros: List<Carro>) {
    if (listaCarros.isNotEmpty()) {
        println("Lista de carros:")
        listaCarros.forEachIndexed { index, carro ->
            println("Carro ${index + 1}: Marca: ${carro.marca}, Modelo: ${carro.modelo}, Año: ${carro.año}")
        }
    } else {
        println("La lista de carros está vacía.")
    }
}

fun buscarCarrosPorMarca(listaCarros: List<Carro>, marcaBuscada: String?) {
    if (marcaBuscada != null && marcaBuscada.isNotBlank()) {
        val carrosEncontrados = listaCarros.filter { it.marca == marcaBuscada }
        if (carrosEncontrados.isNotEmpty()) {
            println("Carros encontrados con la marca '$marcaBuscada':")
            carrosEncontrados.forEachIndexed { index, carro ->
                println("Carro ${index + 1}: Modelo: ${carro.modelo}, Año: ${carro.año}")
            }
        } else {
            println("No se encontraron carros con la marca '$marcaBuscada'.")
        }
    } else {
        println("Marca inválida. Por favor, ingrese una marca válida.")
    }
}
