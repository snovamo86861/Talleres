/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * <p>
 * Estructura de Datos - Taller 06
 * Ejercicio: El Estudiante
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package taller06

class Estudiante(
    val codigo: Int = 1001001001,       // Código del estudiante.
    val nombre: String = "Juliana",     // Nombre del estudiante.
    val apellido: String = "Ramírez"    // Apellido del estudiante.
) {
    // -----------------------------------------------------------------
    // Atributos Adicionales
    // -----------------------------------------------------------------
    var cursos: List<Curso> = emptyList()

    // -----------------------------------------------------------------
    // Métodos Contadores
    // -----------------------------------------------------------------

    /**
     * Determine cuántos cursos tienen un número de créditos par
     */
    fun cursosCodigoPar(): Int {
        var cont= 0
        // Recorrer la lista de cursos
        for ( curso in this.cursos){
            if( curso.creditos%2==0){
                cont++
            }
        }
        // al final, retorno el conatador
        return cont
    }

    /**
     * Determinar y retornar el número de cursos de pregrado que están
     * calificados y cuya carrera sea Sistemas o Ciencia
     */
    fun ejercicio02(): Int {
        val numerodeCursos = cursos.filter { !it.dePostgrado && (it.carrera == "Sistemas" || it.carrera == "Ciencia") }.count()
        return numerodeCursos
    }

    /**
     * Determinar y retornar la cantidad de cursos del estudiante que
     * pertenecen a la carrera que se recibe como parámetro y tienen
     * un número de créditos entre 2 y 4.
     */
    fun ejercicio03(carrera: String): Int {
        val numerodeCurso = cursos.filter { it.carrera == carrera && it.creditos in 2..4 }.count()
        return numerodeCurso
    }

    /**
     * Determinar y retornar cuántos cursos que están calificados
     * fueron aprobados por el estudiante
     */
    fun ejercicio04(): Int {
        var cout =0
        for (curso in this.cursos){
            if (curso.estaCalificado() && curso.aproboCurso())
                cout++
        }
        return cout
    }



    /**
     * Determine y retorne cuantos cursos de pregrado que pertenecen
     * a la carrera que se pasa como parámetro, están calificados
     * y tienen una nota por encima de 20, pero por debajo de 40.
     */
    fun ejercicio05(carrera: String): Int {
        var cout=0
        for(curso in this.cursos){
            if (curso.dePostgrado.not() && curso.carrera==carrera && curso.estaCalificado() && curso.darNota() in 20.0 .. 60.0)
                cout++
        }
        return cout
    }




        /**
         * Halle la suma de los créditos de todos los cursos que tiene
         * el estudiante
         */
        fun ejercicio06(): Int {
            var totalCreditos = 0
            for (curso in cursos) {
                totalCreditos += curso.creditos
            }
            return totalCreditos

        }




    /**
     * Halle la suma de los créditos de aquellos cursos
     * que están calificados y que pertenecen a la carrera
     * que se pasa como parámetro y que fueron aprobados
     */
    fun ejercicio07(carrera: String): Int {
        var TCreditos =0
        for (curso in this.cursos){
            if (curso.estaCalificado() && curso.carrera==carrera && curso.aproboCurso())
                TCreditos += curso.creditos
        }
        return TCreditos
    }


    /**
     * Obtener el promedio normal de las notas de
     * aquellos cursos que han sido calificados
     */
    fun ejercicio08(): Double {
        val gradedCourses = cursos.filter { it.estaCalificado() }
        var sumGrades = 0.0
        gradedCourses.forEach {
            sumGrades += it.darNota()
            return sumGrades / gradedCourses.size
        }
        return ejercicio08()
    }

        /**
     * Calcula el promedio ponderado del estudiante de los cursos que tienen
     * nota asignada. Para hallar el promedio ponderado debe sumarse la
     * multiplicacion de la nota por los creditos y dividirlo por la suma
     * de los créditos. Ojo: SOLO LOS QUE TIENEN NOTA
     */
    fun ejercicio09(): Double {
            var cout=0.0
            var suma =0.0
            for (i in cursos.indices){
                val c=cursos[i]
                if(c.estaCalificado()){
                    cout += c.darNota() * c.creditos
                    suma+=c.creditos
                }
            }
            return cout/suma
        }



    /**
     * Determine y retorne el porcentaje de cursos aprobados
     * del estudiante. Debe ser un número entre 0 y 100
     */
    fun ejercicio10(): Double {
        var c=0
        for ( cur in cursos){
            if (cur.aproboCurso()){
                ++c
            }
        }
        return c /cursos.size.toDouble() * 100
    }

    /**
     * Obtener y retornar el curso que tiene el código que
     * se pasa como parámetro. Si no existe el código en la
     * lista, deberá retornarse null
     */
    fun ejercicio11(codigo: String): Curso? {
        for(x in this.cursos){
            if (x.codigo == codigo)
                return x
        }
        return null
    }

    /**
     * Escriba un método que retorne el código del
     * primer curso que pertenezca a la carrera que
     * se recibe como parámetro y que tiene el número
     * de créditos que se recibe también como parámetro.
     * Si no existe ese curso, deberá retornarse la
     * cadena vacía ("")
     */
    fun ejercicio12(carrera: String, creditos: Int): String {
        for(x in this.cursos){
            if (x.carrera==carrera && x.creditos==creditos)
                return x.codigo
        }
        return ""
    }
}


