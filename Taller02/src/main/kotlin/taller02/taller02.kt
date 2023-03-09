package taller02

import kotlin.math.atan
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Un número complejo consta de una parte real y una parte imaginaria
 * En la clase Producto:
 *
 * Para calcular el precio final de cada producto, se deben sumar los impuestos que define la ley (IVA).
 * Dichos impuestos dependen del tipo del producto, de la siguiente manera:
 *
 * papeleria: 16%
 * supermercado: 4%
 * drogueria: 12%.
 */
class NumeroComplejo(var parteReal: Double, var parteImaginaria: Double) {
    // Halla el valor absoluto del número complejo
    // https://www.varsitytutors.com/hotmath/hotmath_help/topics/absolute-value-complex-number-spanish
    fun valorAbsoluto(): Double {
        return sqrt(parteReal.pow(2) +parteImaginaria.pow(2))
    }

    // Halla la fase o argumento del número complejo
    // https://www.superprof.es/diccionario/matematicas/aritmetica/argumento.html
    fun argumento()= atan(parteImaginaria/parteReal)


    // Halla el inverso o recíproco de un número complejo
    //The inverse (or reciprocal) of a complex number is found by dividing 1 by the complex number.
    //The inverse or reciprocal of a complex number z = a + bi, is given by z-1 = a/(a2 + b2) - bi/(a2 + b2).
    //For example, if the complex number is a + bi, then the inverse is 1 / (a + bi).

    /*

   fun getInverseComplex(num: ComplexNumber): ComplexNumber {}
    val realPart = num.realPart / (num.realPart.pow(2) + num.imaginaryPart.pow(2))
    val imaginaryPart = -num.imaginaryPart / (num.realPart.pow(2) + num.imaginaryPart.pow(2))
    return ComplexNumber(realPart, imaginaryPart)
}
     */


    fun inverso(): NumeroComplejo {

        val d=parteReal.pow(2)+parteImaginaria.pow(2)
        val pri=parteReal/ d
        val pii= -parteImaginaria/d
        return NumeroComplejo(pri,pii)
    }

    // Multiplica la parte real y la parte imaginaria por un escalar
    fun productoPorEscalar(escalar: Double) {
        parteReal *= escalar
        parteImaginaria*=escalar
    }

    // Obtiene una versión String del número complejo
    override fun toString(): String {
        return String.format("%.2f + (%.2f)i", parteReal, parteImaginaria)
    }
}

// Función externa que halla la suma de dos números complejos
//es una funcion externa porque arriba se acaba la clase
//dentro de las funciones ecternas no tengo acceso a los atributos
fun sumarNumComplejos(num1: NumeroComplejo, num2: NumeroComplejo): NumeroComplejo {
    //sacar la parte real de num1
    val a = num1.parteReal
    val b = num1.parteImaginaria
    val c = num2.parteReal
    val d = num2.parteReal


    return NumeroComplejo(a + c, b + d)

}

// -----------------------------------------------------------------------------------
/*
* Un número complejo consta de una parte real y una parte imaginaria
* En la clase Producto:
*
* Para calcular el precio final de cada producto, se deben sumar los impuestos que define la ley (IVA).
* Dichos impuestos dependen del tipo del producto, de la siguiente manera:
*
* papeleria: 16%
* supermercado: 4%
* drogueria: 12%.
*/
// Clase Producto

// Clase Producto
class Producto(val nombre: String, // Propiedades: nombre, tipo, valorunitario, vantidad bodega, cantidad minima son atributos
               val tipo: String,
               var valorUnitario: Double,
               var cantidadBodega: Int,
               val cantidadMinima: Int) {
    //Metodo
    // //Retornar el IVA correspondiente al producto. Ojo: este IVA depende del tipo de producto.
    fun darIVA(): Double {
        return when (tipo) {
            "papeleria" -> 0.16
            "supermercado" -> 0.4
            "drogueria" -> 0.12
            else -> 0.0
        }
    }
//https://www.baeldung.com/kotlin/this-keyword#:~:text=In%20Kotlin%2C%20the%20%E2%80%9Cthis%E2%80%9D,we%20happen%20to%20be%20running.
    //Use of this , check the link
    fun calcularPrecioFinal(): Double {
        return this.valorUnitario + this.valorUnitario * this.darIVA()

    }

    // Vende la cantidad de unidades dada por parámetro.

    fun vender(cantidad: Int): Int {
        if (cantidadBodega <= cantidad ) {
            cantidadBodega -= cantidad
        }
        return cantidad
    }
/*
if (condition1) {
  // block of code to be executed if condition1 is true
} else if (condition2) {
  // block of code to be executed if the condition1 is false and condition2 is true
} else {
  // block of code to be executed if the condition1 is false and condition2 is false
}
 */
    fun abastecer(cantidad: Int): Int{

        if (cantidadBodega <= cantidad) {

            cantidadBodega += cantidad
        } else if (cantidadBodega >= cantidad) {

            cantidadBodega  += cantidad
        } else if ( cantidadBodega == 0){
            println("Abastecer con minimo 1")
        }else {

            println("No se pudo abastecer")
        }

        return cantidad
    }

    // retorna True sin la cantidad en Bodega es menor que la cantidad mínima, y False en caso contrario.
    /*
    https://www.w3schools.com/kotlin/kotlin_when.php
    https://kotlinlang.org/docs/control-flow.html#when-expression
     */
    fun puedeAbastecer(): Boolean {
        return when {
            this.cantidadBodega < cantidadMinima -> true
            else -> false
        }

    }

    // Obtener una representación visual de un producto.
    override fun toString(): String {
        return "Producto(nombre='$nombre', tipo='$tipo', valorUnitario=$valorUnitario, cantidadBodega=$cantidadBodega, cantidadMinima=$cantidadMinima)"
    }

}
