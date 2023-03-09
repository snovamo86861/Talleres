/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Tecnología - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Ejercicio: Listas en Kotlin
 * Autor: Universidad EAN - 23 de febrero de 2022
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller07

/**
 * Información que mantenemos de una persona
 */
data class Persona(
    val cedula: Int,
    val edad: Int,
    val genero: String,             // "M" para masculino, "F" para Femenino
    val hijos: Int,
    val nivelEducativo: String,     // PRIMARIA, SECUNDARIA, PREGRADO, POSTGRADO
    val estrato: Int,
    val ingresos: Int,
    val peso: Int,                  // Peso en kilos
    val altura: Int,                // altura en centímetros
    val fuma: Boolean,
    val tieneLentes: Boolean,
    val tieneCasa: Boolean,
    val tieneAutomovil: Boolean
) {
    /**
     * Este método obtiene el año de nacimiento de la persona en el 2023
     */
    fun añoNacimiento(): Int = 2023-edad

    /**
     * Método que retorna el impuesto que debe pagar la persona.
     * Si la persona es de estrato 1 o 2, este impuesto corresponde al 5% de los ingresos
     * Para los otros estratos corresponde a la décima parte del ingreso más 10 mil pesos
     * multiplicado por el estrato
     */
    fun impuesto(): Double {
        if (estrato in 1 .. 2 ){
            return ingresos * 0.05
        }
        return (ingresos/10.0)+10000*estrato
    }
}

//-----------------------------------------------------------------------------
// Operaciones a llevar a cabo
//-----------------------------------------------------------------------------
//Esto no es un metodo, es una funcion externa
fun contarMujeresConAutomovil(personas: List<Persona>): Int {
    var cont = 0;
    for (p in personas) {
        if (p.genero == "F" && p.tieneAutomovil) {
            cont++
        }
    }
    return cont
}

/**
 * Contar el número de personas que pesan entre 60 y 80 kilos
 */
fun ejercicio1a(personas: List<Persona>): Int {
    var cout=0
    for (p in personas){
        if( p.peso in 60 .. 80){
            cout++
        }
    }
    return cout

}

/**
 * Determinar si la cantidad de mujeres es superior a la cantidad de hombres
 * El método deberá retornar true si hay más mujeres que hombres y false
 * en caso contrario.
 */
fun ejercicio1b(personas: List<Persona>): Boolean {
    for (p in personas) {
        if (p.genero in "M".."F") {
            return true
        }
    }
    return false
}

/**
 * Encontrar la suma de los ingresos de aquellas personas
 * que no fuman y que sean mayores de 50 años de edad
 */
fun ejercicio2a(personas: List<Persona>): Int {
    var cout=0
    for (p in personas){
        if (!p.fuma && p.edad>50){
            cout+= p.ingresos
        }
    }
    return cout
}

/**
 * Escriba una función que retorne la suma de los pesos
 * de las personas de genero femenino, cuyo cédula es par
 * y no tiene hijos
 */
fun ejercicio2b(personas: List<Persona>): Int {
    var cout =0
    for (p in personas){
        if(p.genero=="F" && p.cedula%2==0 && p.hijos==0){
            cout += p.peso
        }
    }
    return cout
}

/**
 * Escriba una función que retorne el promedio de edad
 * de los hombres que se ganan entre 2 y 3 millones
 */
fun ejercicio3a(personas: List<Persona>): Double {
    var cout=0.0
    var suma=0.0
    for (p in personas){
        if (p.genero=="M" && p.ingresos in 2000000 .. 3000000){
            cout++
            suma+=p.edad

        }
    }
    return suma/cout
}

/**
 * ¿Cual es el promedio de ingresos de aquellas personas que tienen una
 * altura inferior a 170 centímetros, y que pesan entre 80 y 90 kilos
 * y no fuman ni usan lentes y cuyo nivel educativo sea igual al que
 * se pasa como parámetro
 */
fun ejercicio3b(personas: List<Persona>, nivel: String): Double {
    var cout=0.0
    var suma=0.0
    for (p in personas){
        if (p.altura<170 && p.peso in 80 .. 90 && !p.fuma && !p.tieneLentes && p.nivelEducativo == nivel){
            cout++
            suma+=p.ingresos
        }
    }
    return suma/cout
}

/**
 * Cuál es el porcentaje de mujeres que viven en estrato 1, 2 o 3 y que tienen casa
 */
fun ejercicio3c(personas: List<Persona>): Double {
    var X=0
    for (per in personas){
        if (per.genero=="F" && per.estrato in 1 ..3 && per.tieneCasa){
            ++X
        }
    }
    return X / personas.size.toDouble()*100
}

/**
 * Hallar el indice de masa corporal de una persona
 * Este indice se halla p / h^2, donde p es el peso en kilos, y h es la altura
 * en metros.
 * hay que convertir cm a metros
 */
fun imc(persona: Persona): Double  {
    return persona.peso / (persona.altura/100.0*persona.altura/100.0)
}

/**
 * El nivel de peso de una persona depende del imc de esa persona
 * de acuerdo a la siguiente:
 * nivel = "Bajo peso" cuando el imc está por debajo de 18.5
 * nivel = "Normal" cuando el imc está entre 18.5 y 24.9
 * nivel = "Sobrepeso" cuando el imc está entre 25.0 y 29.9
 * nivel = "Obesidad" cuando el imc es 30.0 o superior
 * Escriba una función que halle el nivel de peso de una persona
 * USE LA FUNCIÓN IMC HECHA ANTERIORMENTE
 * Aqui no hay una lista, no hay que usar listas en este ejrcicio
 */
fun nivelPeso(p: Persona): String {
    if (imc(p)<18.5){
        return "Bajo peso"
    }
    else if (imc(p)>=18.5 && imc(p) < 25){
        return "Normal"
    }
    else if (imc(p)>=25.0 && imc(p)<= 29.9){
        return "Sobrepeso"
    }
    else  {
    }
    return "Obesidad"
}

/**
 * Halle el promedio de edad de los hombres obesos
 */
fun ejercicio3d(personas: List<Persona>): Double {
    var cout=0
    var sum=0.0
    for (p in personas){
        if (p.genero=="M" && imc(p)>30.0 ){
            cout++
            sum+=p.edad
        }
    }
    return sum/cout
}

/**
 * Hallar la cédula de la mujer más alta
 */
fun ejercicio4a(personas: List<Persona>): Int {
    var mayorAltura = 0
    var cedulaMujerMasAlta = 0

    for(persona:Persona in personas){
        if(persona.genero == "F"){
            if(persona.altura > mayorAltura){
                mayorAltura = persona.altura
                cedulaMujerMasAlta = persona.cedula
            }
        }
    }
    return cedulaMujerMasAlta
}

/**
 * Escriba una función que retorne la cédula del hombre
 * mayor de 30 años que tiene los ingresos más bajos
 */

//tiene que ser hombre, mayor de 30 años e ingresos mas bajos
//minBy() devuelve el primer elemento que tiene
// el valor más pequeño del selector de función dado: (T) -> R o 'nulo' si no hay elementos.
fun ejercicio4b(personas: List<Persona>): Int {
    return personas.filter { it.genero == "M" && it.edad >= 30 }
        .minBy { it.ingresos }.cedula
}



/**
 * Escriba una función que retorne la lista de las
 * cédulas de aquellas mujeres que no tienen casa
 * no tienen hijos y tienen un nivel de peso normal
 */
// es un Int porque la cedula tiene tiene numero entero
// se puede hacer asi porque es una lista mutable.

fun ejercicio05(personas: List<Persona>): MutableList<Int> {
    val resultado = mutableListOf<Int>()

    for(persona in personas) {
        if (persona.genero == "F" && !persona.tieneCasa && persona.hijos == 0 && nivelPeso(persona)=="Normal")
        //aqui cojo solo la cedula
            resultado.add(persona.cedula)
    }

    return resultado
}

/**
 * Escriba una función que retorne una lista con las personas
 * que pagan menos de 250 mil pesos en impuesto pero que tiene
 * carro y que viven en estrato 4 y tienen un pregrado o un
 * postgrado
 */


fun ejercicio05b(personas: List<Persona>): List<Persona> {

    val resultadoPersonas = mutableListOf<Persona>()
    for (p in personas) {
        //val calcularImpuestos = p.impuesto()
        if ((p.estrato == 4) && p.tieneAutomovil &&
            ((p.nivelEducativo == "PREGRADO") || (p.nivelEducativo == "POSTGRADO")) && (p.impuesto() <= 250000)
        ) {
            resultadoPersonas.add(p)
        }
    }
    return resultadoPersonas


}




/**
 * Escriba una función que retorne cuál de los 4 estratos tiene la mayor
 * cantidad de hombres.
 */

fun ejercicio06(personas: List<Persona>): Int {
    val hombresP = personas.filter { it.genero == "M" }
    val estratoH  = mutableMapOf<Int, Int>()
    hombresP.forEach {
        estratoH[it.estrato] = estratoH.getOrDefault(it.estrato, 0) + 1
    }
    return estratoH.maxBy { it.value }.key ?: 0
}
