/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Geometría
 * Autor: Universidad EAN - 07 de febrero de 2023
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller05

import kotlin.math.PI
import kotlin.math.pow


/**
 * Ejercicio 5
 */
fun ejercicio05(r: Double): Double {
    val CP = Circulo(r)
    val CG = Circulo(2*r)
    return CG.area()-CP.area()
}

/**
 * Ejercicio 6
 */
fun ejercicio06(u: Double): Double {
    val RP = Rectangulo(3*u, 2*u)
    val RG = Rectangulo(5*u, 2*u)
    val triangulo = Triangulo(3*u, 4*u)
    return RP.area()+RG.area()+triangulo.area()
}

/**
 * Ejercicio 07
 */
fun ejercicio07(x: Double): Double {
    val CA = Cuadrado(x)
    val CI = Circulo(x/2)
    return CA.area() - CI.area()

}

/**
 * Ejercicio 08 - Hipotenusa
 */
fun ejercicio08(tri: Triangulo): Double {
    return Math.sqrt( tri.base*tri.base + tri.altura * tri.altura)
}


/**
 * Ejercicio 09
 */
fun ejercicio09(a: Double, b: Double): Double {
    val TR = Triangulo(a,b)
    val CG=Circulo(Math.sqrt (PI*Math.sqrt(TR.base *TR.base/2 + TR.altura * TR.altura/2)/(Math.sqrt(TR.base*TR.base/2 + TR.altura * TR.altura/2))))
    return TR.area() + CG.area()

}


/**
 * Ejercicio 10
 */
fun ejercicio10(r: Double): Double {
    val CI=Circulo(r)
    val CA=Cuadrado(2*r/Math.sqrt(2.0))
    return CI.area()-CA.area()
}

/**
 * Ejercicio 11
 */
fun ejercicio11(r: Double, a: Double): Double {
    val CR= Circulo(r)
    val radioHipotenusa =(r * 2)
    val ladoCuadrado = Math.sqrt(Math.pow(radioHipotenusa, 2.0) / 2)
    val areaCuadrado = ladoCuadrado * ladoCuadrado
    return Circulo(r).area()- areaCuadrado - (r * ladoCuadrado/a )/2
}



/**
 * Ejercicio 12
 */
fun ejercicio12(x: Double, y: Double, z: Double): Double {
    val TR = Triangulo(y,z/2)
    val H= Math.sqrt( TR.base*TR.base + TR.altura * TR.altura)
    val s = (x + y + z) / 2
    val area = Math.sqrt(s * (s - x) * (s - y) * (s - z))
    return (area + H)*2
}



/**
 * Ejercicio 13
 */
fun ejercicio13(a: Double, b: Double, c: Double, d: Double, e: Double): Double {
    val triangulo = Triangulo(b, c)
    val rectangulo = Rectangulo(e, d)
    val areaTriangulo = triangulo.area()
    val areaRectangulo = rectangulo.area()
    val areaPuerta = a / b
    val areaSombreada = areaRectangulo - areaPuerta - areaTriangulo
    return areaSombreada
}





