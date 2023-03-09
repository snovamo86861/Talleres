/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 *
 * Unidad de Estudios: Estructura de Datos
 * Taller: 01
 * Fecha: 1 de febrero de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 */
package taller01

import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

/* Ejercicio 01 */
fun ejercicio01(primerCorte: Double, segundoCorte: Double, pruebasObjetivas: Double): Double {
    return (((primerCorte * 0.4) + (segundoCorte * 0.5) + (pruebasObjetivas * 0.1)))
}


/* Ejercicio 02 */

/*
Juancho ha calculado que le toma 24 segundos caminar 100 metros,
y quiere que le escribamos una función donde dado el número de metros
que hay entre su casa y la tienda de la esquina, le retorne cuánto
tiempo en segundos le tomaría ir y regresar de la tienda.
 */
fun ejercicio02(metros: Double): Double {


    return metros * 48 / 100
}

/* Ejercicio 03 */

fun ejercicio03(x: Double, y: Double): Double {
    return x*x + 2*x*y + y*y
}


/*
** Escriba una función en Kotlin que
* halle el área y el perímetro de un rectángulo a partir de la base
* y la altura del rectángulo (OJO: Una sola función).
 */
/* Ejercicio 04 */
fun ejercicio04(base: Double, altura: Double): Pair<Double, Double> {
    val perimetro = (base * 2 ) + (altura * 2)
    val  area = base * altura

    return area to perimetro

}
/*
 El paseo: ya que se acabó la pandemia, vamos a organizar un paseo.
 Al paseo irán estudiantes gordos y flacos. Un estudiante gordo ocupa dos sillas de un bus
 y un estudiante flaco ocupa solo una silla. Si sabemos cuánta sillas tiene un bus,
  cuántos estudiantes gordos van al paseo y cuántos estudiantes flacos van al paseo,
   escriba una función encuentre y retorne el número de buses que se necesitan alquilar
   para llevar a todos esos estudiantes al paseo.
 */
/* Ejercicio 05 */
fun ejercicio05(gordos: Int, flacos: Int, numSillasBus: Int): Int {

    val busesTotal = Math.ceil((gordos * 2 + flacos) / numSillasBus.toDouble())



    return busesTotal.toInt()
}


/*
Escriba una función que calcule la longitud de la escalera
 teniendo en cuenta que conocemos la altura
 que tiene la escalera cuando está inclinada sobre la pared con un ángulo
. Tenga en cuenta la siguiente figura:
 */
/* Ejercicio 06 */
fun ejercicio06(x: Double, alfa: Double): Double {
    val y  = x/ sin(alfa)
    return y
}



/*
 Escriba una función en Kotlin que resuelva el siguiente problema:
 Pedro acabó de recibir el sueldo mensual. Si se gasta el 40% de ese sueldo en el arriendo
  y el 15% del sueldo en comida, determine y retorne cuánto dinero se gastó en cada uno de
  esos dos ítems (en arriendo y en comida) y cuanto dinero le queda al final.
 */
/* Ejercicio 07 */
fun ejercicio07(sueldo: Double): Triple<Double, Double, Double> {
    val renta = sueldo * 0.4
    val comida = sueldo * 0.15
    val sobrante = sueldo - renta - comida
    return Triple(renta.toDouble(), comida.toDouble(), sobrante.toDouble())
}

/*
Un triángulo isosceles es un triángulo donde se tienen que dos lados son iguales,
 tal como se muestra en la figura a continuación.
 Escriba una función que encuentra y retorne el perímetro (
), la altura del triángulo (
) y el áreas del triángulo (
) a partir de los lados
 y
. Use obligatoriamente las siguientes fórmulas:

 */
/* Ejercicio 08 */
fun ejercicio08(a: Double, b: Double): Triple<Double, Double, Double> {
    val p = b + 2 * a
    val h = sqrt(a * a - b / 4)
    val A = (h * h) / 2

    return Triple(p, h, A)
}


/*
 Escriba una función que halle y retorne el área de un círculo de acuerdo a la conocida fórmula


 */
/* Ejercicio 09 - Area del circulo*/
fun ejercicio09(r: Double): Double {
    return Math.PI * Math.pow(r, 2.0)

}

/* Escriba una función que halle y retorne el área de una corona circular (la región en verde en la siguiente figura)
a partir del radio del círculo interno (r) y del círculo externo (R). Como se puede observar,
esta área de la corono circular se obtiene restando el área del círculo pequeño del área del círculo grande.
En esta función tiene OBLIGATORIAMENTE que utilizar la función realizada en el Ejercicio 09.
* */
/* Ejercicio 10  - area de la corona circular*/

fun ejercicio10(r: Double, R: Double): Double {
    return ejercicio09(R) - ejercicio09(r)
}





/* Ejercicio 11
Un profesor diseña un examen con n preguntas y estima que para calificar cada pregunta requiere m minutos.
Si el examen se aplica a k estudiantes, ¿Cuánto tiempo (horas y minutos) necesita para calificar todos
 los exámenes?.
 //% Modulus	Returns the division remainder
 //    /	Division	Divides one value from another
 */
fun ejercicio11(n: Int, m: Int, k: Int): Pair<Int, Int> {
    val min = (n * k * m) % 60
    val horas = (n * k * m) / 60

    return Pair(horas,min)
}


/*
Escriba una función en Kotlin en el que a partir de los nombres
y las edades de tres hermanos, obtenga y retorne el nombre del hermano mayor.
 */
/* Ejercicio 12 */
fun ejercicio12(nombreHermano1: String, edadHermano1: Int,
                nombreHermano2: String, edadHermano2: Int,
                nombreHermano3: String, edadHermano3: Int): String {
    return if (edadHermano1 >= edadHermano2 && edadHermano1 >= edadHermano3) {
        nombreHermano1
    } else if (edadHermano2 >= edadHermano1 && edadHermano2 >= edadHermano3) {
        nombreHermano2
    } else {
        nombreHermano3
    }
}


/* Ejercicio 13
*  La empresa La Generosa S.A desea aumentar el sueldo a sus empleados, para ello ha establecido las siguientes
* condiciones: quienes ganan menos de $ 800.000 tendrán un aumento del 10%, quienes devengan entre $ 800.000
* y $1’200.000 recibirán un aumento del 8% y los que ganan más del millón doscientos, tendrán un aumento del 5%.
* Se requiere una función que calcule y retorne el valor del aumento y el nuevo salario para un empleado.
* */
fun ejercicio13(salario: Double): Pair<Double, Double> {
    var aumento:Double=0.0
    var nuevo_sueldo:Double=0.0
    if (salario<=800000.0){
        aumento=salario*0.10
        nuevo_sueldo=salario+aumento
    }else if(salario>800000.0 && salario<=1200000.0){
        aumento=salario*0.08
        nuevo_sueldo=salario+aumento
    }else if (salario>1200000.0) {
        aumento = salario * 0.05
        nuevo_sueldo = salario + aumento
    }else{

    }
    return Pair(aumento,nuevo_sueldo)
}



/* Ejercicio 14
* Un año es bisiesto si es múltiplo de 4 pero no de 100,
* también se es bisiesto cuando es múltiplo de 400.
* Escriba una función que reciba un año (un número entero) y que retorne si ese año es bisiesto o no.
* Ejemplo: 2024 es bisiesto, pero 1900 no lo fue.

*/
fun ejercicio14(año: Int): Boolean {
    return (año % 4 == 0 && año % 100 != 0) || año % 400 == 0
}


