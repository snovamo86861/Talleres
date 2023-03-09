/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudios de Estructura de Datos
 * Ejercicio: Triangulo
 * Basado en el ejercicio de Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package triangulo.mundo

import java.time.Year
import kotlin.math.tan

/**
 * Clase que representa un triángulo.
 */
class Triangulo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Primer punto del triángulo.
     */
    private val punto1: Punto = Punto(200.0, 50.0)

    /**
     * Segundo punto del triángulo.
     */
    private val punto2: Punto = Punto(300.0, 200.0)

    /**
     * Tercer punto del triángulo.
     */
    private val punto3: Punto = Punto(100.0, 200.0)

    /**
     * Color de las líneas.
     */
    private val colorLineas: Color = Color(60, 168, 56)

    /**
     * Color del relleno.
     */
    private val colorRelleno: Color = Color(0, 83, 24)

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el punto 1 del triángulo.
     * @return Punto 1.
     */
    fun darPunto1(): Punto {
        return punto1

    }

    /**
     * Retorna el punto 2 del triángulo.
     * @return Punto 2.
     */
    fun darPunto2(): Punto {
        return punto2

    }

    /**
     * Retorna el punto 3 del triángulo.
     * @return Punto 3.
     */
    fun darPunto3(): Punto {
        return punto3
    }

    /**
     * Retorna el color de las líneas del triángulo.
     * @return Color de las líneas.
     */
    fun darColorLineas(): Color {
        return colorLineas
    }

    /**
     * Retorna el color del relleno del triángulo.
     * @return Color del relleno.
     */
    fun darColorRelleno(): Color {
        return colorRelleno
    }

    /**
     * Retorna el perímetro del triángulo.
     * @return Perímetro del triángulo.
     */
    fun darPerimetro(): Double {
        // Retorna la suma de todos los lados
        val lado1   = calcularLado1()
        val  lado2 = calcularLado2()
        val lado3 = calcularLado3()
        return lado1 + lado2 + lado3

    }

    /**
     * Retorna el área del triángulo, calculada utilizando la formula de Herón. <br></br>
     * @return Área del triángulo.
     */
    fun darArea(): Double {
        // Calcula y devuelve el área
        val perimetro = darPerimetro()
        val semiPerimetro = perimetro / 2
        return  Math.sqrt(semiPerimetro*(semiPerimetro * perimetro))
    }

    /**
     * Calcula la altura del triángulo, teniendo en cuenta como base la línea entre el punto 1 y 2. <br></br>
     * Tenga en cuenta que Área = (Base * Altura) / 2.
     * @return Altura del triángulo.
     */
    fun darAltura(): Double {
        val base:Double = calcularLado3()
        val altura:Double = (2*darArea())/base
        return altura
    }

    /**
     * Calcula la distancia entre el punto 1 y 2.
     * @return Distancia entre el punto 1 y el punto 2.
     */
    private fun calcularLado1(): Double {
        // calcula la distancia
        val xcuadrado = Math.pow(punto2.darX()-punto1.darX(),2.0)
        val ycuadrado = Math.pow(punto2.darY()-punto1.darY(),2.0)
        return Math.sqrt(xcuadrado+ycuadrado)
    }

    /**
     * Calcula la distancia entre el punto 2 y 3.
     * @return Distancia entre el punto 2 y 3.
     */
    private fun calcularLado2(): Double {
        // calcula la distancia
        val xcuadrado = Math.pow(punto2.darX()-punto3.darX(),2.0)
        val ycuadrado = Math.pow(punto2.darY()-punto3.darY(),2.0)
        return Math.sqrt(xcuadrado+ycuadrado)
    }

    /**
     * Calcula la distancia entre el punto 3 y 1.
     * @return Distancia entre el punto 3 y 1.
     */
    private fun calcularLado3(): Double {
        // calcula la distancia
        val xcuadrado = Math.pow(punto3.darX()-punto1.darX(),2.0)
        val ycuadrado = Math.pow(punto3.darY()-punto1.darY(),2.0)
        return Math.sqrt(xcuadrado+ycuadrado)
    }

    /**
     * Calcula el ángulo opuesto entre un vértice de referencia y los otros dos vértices de un triángulo.
     * @param pX1 Coordenada X del vértice de referencia.
     * @param pY1 Coordenada Y del vértice de referencia.
     * @param pX2 Coordenada X del vértice opuesto 1.
     * @param pY2 Coordenada Y del vértice opuesto 1.
     * @param pX3 Coordenada X del vértice opuesto 2.
     * @param pY3 Coordenada Y del vértice opuesto 2.
     * @return Ángulo opuesto entre vértice de referencia y los otros dos vértices.
     */
    fun calcularAnguloOpuesto(pX1: Double, pY1: Double, pX2: Double, pY2: Double, pX3: Double, pY3: Double): Double {
        // Ángulo 1
        var angulo1 = Math.atan2(pY2 - pY1, pX2 - pX1)

        // Ángulo 2
        var angulo2 = Math.atan2(pY3 - pY1, pX3 - pX1)

        // Garantiza que la diferencias de ángulos sea la más pequeña.
        if (Math.abs(angulo1 - angulo2) > Math.PI) {
            angulo1 = if (angulo1 < 0) angulo1 + 2.0 * Math.PI else angulo1
            angulo2 = if (angulo2 < 0) angulo2 + 2.0 * Math.PI else angulo2
        }

        // Calcula el ángulo opuesto
        var anguloOpuesto = (angulo1 + angulo2) / 2.0 + Math.PI
        anguloOpuesto = anguloOpuesto % (2.0 * Math.PI)
        return anguloOpuesto
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 1.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto1(pX: Double, pY: Double) {
        if(pX>0 && pY >0){
            punto1.cambiarX(pX)
            punto1.cambiarY(pY)
        }
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 2.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto2(pX: Double, pY: Double) {
        if(pX>0 && pY >0){
            punto2.cambiarX(pX)
            punto2.cambiarY(pY)
        }
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 3.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto3(pX: Double, pY: Double) {
        if(pX>0 && pY >0){
            punto3.cambiarX(pX)
            punto3.cambiarY(pY)
        }
    }

    /**
     * Cambia el color de relleno del triángulo.
     * @param pRojo Valor de componente rojo del RGB. pRojo >= 0.
     * @param pVerde Valor de componente verde del RGB. pVerde >= 0.
     * @param pAzul Valor de componente azul del RGB. pAzul >= 0.
     */
    fun cambiarColorRelleno(pRojo: Int, pVerde: Int, pAzul: Int): String {
        val nuevoColor= " "
        if(pRojo>=0 && pVerde >=0 && pAzul>=0){
            colorRelleno.cambiarRojo(pRojo)
            colorRelleno.cambiarVerde(pVerde)
            colorRelleno.cambiarAzul(pAzul)
        }
        return nuevoColor
    }

    /**
     * Cambia el color de la líneas del triángulo.
     * @param pRojo Valor de componente rojo del RGB. pRojo >= 0.
     * @param pVerde Valor de componente verde del RGB. pVerde >= 0.
     * @param pAzul Valor de componente azul del RGB. pAzul >= 0.
     */
    fun cambiarColorLineas(pRojo: Int, pVerde: Int, pAzul: Int) {
        if(pRojo>=0 && pVerde >=0 && pAzul>=0){
            colorLineas.cambiarRojo(pRojo)
            colorLineas.cambiarVerde(pVerde)
            colorLineas.cambiarAzul(pAzul)
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Permite obtener el tipo del triángulo
     * "equilátero" si los tres lados son iguales
     * "isosceles" si dos lados son iguales
     * "escaleno" si los tres lados son diferentes
     */
    fun tipo(): String {
        val lado1= calcularLado1()
        val lado2 = calcularLado2()
        val lado3 = calcularLado3()
        return if (lado1==lado2 && lado1==lado3 && lado2==lado3) {
            "equilátero"
        } else if (lado1==lado2 || lado1==lado3 || lado2==lado3) {
            "isosceles"
        } else {
            "escaleno"
        }
    }

    /**
     * Permite obtener el punto en el centro del triángulo, conocido como el centroide
     */
    fun centroide(): Punto {
        var pX1 = punto1.darX()
        var py1 = punto1.darY()
        var pX2 = punto2.darX()
        var pY2 = punto2.darY()
        var pX3 = punto3.darX()
        var pY3 = punto3.darY()
        val centroide_x = (pX1 + pX2 + pX3 ) / 3
        val centroide_y = (py1 + pY2 + pY2 ) / 3
        return Punto(centroide_x, centroide_y)
    }

}



/**
 * Permite obtener el punto que se encuentra en el incentro del triángulo t
 * El incentro es el punto donde las bisectrices de los tres ángulos internos
 * se intersecan.
 * https://www.neurochispas.com/wiki/incentro-de-un-triangulo-definicion-formulas-y-ejemplos/
 */
fun incentro(t: Triangulo): Punto {
    var pX1 = t.darPunto1()
    var pY1 = t.darPunto1()
    var pX2 = t.darPunto2()
    var pY2 = t.darPunto2()
    var pX3 = t.darPunto3()
    var pY3 = t.darPunto3()
    val a = Math.sqrt((pX1 - pX3) * (pX2 - pX3) + (pY2 - pY3) * (pY2 - pY3))
    val b = Math.sqrt((pX1 - pX3) * (pX1 - pX3) + (pY1 - pY3) * (pY1 - pY3))
    val c = Math.sqrt((pX3-pX2) * (pX1 - pX2) + (pY1 - pY2) * (pY1 - pY2))
    val incentroX = (a * pX1 + b * pX2 + c * pX3) / (a + b + c)
    val incentroY = (a * pY1 + b * pY2 + c * pY3) / (a + b + c)
    return Punto(incentroX, incentroY)



}
