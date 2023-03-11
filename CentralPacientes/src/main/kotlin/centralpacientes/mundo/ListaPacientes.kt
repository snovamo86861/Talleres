/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralpacientes.mundo

import ean.collections.TArray
import kotlin.jvm.Throws

// -----------------------------------------------------------------
// Constantes
// -----------------------------------------------------------------

/**
 * Constante para representar el número máximo de paciente en la lista
 */
const val MAX_PACIENTES = 20

// -----------------------------------------------------------------
// Excepciones
// -----------------------------------------------------------------

/**
 * Excepción que informa que el paciente que se va a agregar
 * ya está registrado en la central de pacientes
 */
class YaExisteException(codigo: Int) :
    Exception("El paciente con código $codigo ya está registrado")

/**
 * Excepción generada cuando un paciente con un código dado no existe
 */
class NoExisteException(codigo: Int) :
    Exception("El paciente con código $codigo no está registrado")

// -----------------------------------------------------------------
// Clases
// -----------------------------------------------------------------

/**
 * Esta clase representa una lista con todos los pacientes que se maneja en una
 * central de la ciudad.
 *
 * Es un arreglo disfrazado de lista
 */
class ListaPacientes() {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Arreglo con la información de los pacientes.
     * Estos arrreglos son privados.
     */
    private val pacientes: TArray<Paciente> = TArray(MAX_PACIENTES)

    /**
     * Número actual de pacientes en el arreglos
     */
    private var numPacientes: Int = 0

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de pacientes de la clínica
     */
    fun darNumeroPacientes(): Int = numPacientes

    /**
     * Busca el paciente con el código dado en el arreglo de pacientes.
     *
     * Retorna la posición del paciente en el arreglo o -1 si no hay
     * paciente con ese código.
     *
     * Esta es una busqueda.
     */
    fun obtenerPosicionPaciente(codigo: Int): Int {
        for (i in 0 until numPacientes){
            if (pacientes[i].codigo == codigo){
                return i
            }
        }
        return -1
            //obteniendo el paciente
            //if(pacientes)
    }

    /**
     * Retorna el paciente que se encuentra en la posición
     * especificada del arreglo.
     * Si no se cumple, el programa no funcionara
     * Como obtengo el paciente en la posicion
     */
    fun obtenerPaciente(posicion: Int): Paciente {
        require(posicion in 0 until numPacientes)
        return pacientes [posicion]

    }

    /**
     * Permite obtener el paciente con el código dado
     *
     * Si no existe el paciente con ese código, deberá
     * retornarse un null
     * aqui no se retorna la posicion sino el paciente
     */
    fun localizar(cod: Int): Paciente? {
        for(i in 0 until numPacientes){
            if(pacientes[i].codigo == cod){
                return pacientes[i]
            }
        }
        return null
    }


    /**
     * Adiciona un paciente al principio del arreglo de pacientes
     *
     * Si ya existe un paciente con el código igual a pac.codigo
     * se debe genera  una excepción YaExistePaciente
     * cuando es -1 es que no existe
     * no tiene return porque no tiene dato de salida
     *
     */
    fun agregarPacienteAlComienzo(pac: Paciente) {
        require(numPacientes < MAX_PACIENTES)
    //vemos si el paciente esta repetido
        if (obtenerPosicionPaciente(pac.codigo) != -1) {
            throw YaExisteException(pac.codigo)
        }

        //correr todos los pacientes a la derecha
        //para abrirle un espacio al nuevo paciente
        for (i in numPacientes downTo  1){
            pacientes[i] = pacientes[i-1]
        }
        //Guardo el paciente en la posicion 0 (en el comiezo)
        pacientes[0]=pac
        //Incremento el numero de pacientes.
        numPacientes++


    }
    /**
     * Adiciona un paciente al final del arreglo de pacientes
     *
     * Si ya existe un paciente con el código igual a pac.codigo
     * se debe genera  una excepción YaExistePaciente
     */
    fun agregarPacienteAlFinal(pac: Paciente) {
        require(numPacientes < MAX_PACIENTES)
        if (obtenerPosicionPaciente(pac.codigo) != -1) {
            throw YaExisteException(pac.codigo)
        }
        //Agregar pacientes
        pacientes[numPacientes] = pac
        ++numPacientes

    }

    /**
     * Adiciona un paciente al arreglo de pacientes antes
     * del paciente con el código especificado.
     *
     * Si ya existe un paciente con el código igual a pac.codigo
     * se debe genera  una excepción YaExistePaciente
     * primero se debe sacar la posicion del paciente , y despues correr apartir de la poscion encontrada del paciente
     */
    fun agregarPacienteAntesDe(cod: Int, pac: Paciente) {
        TODO("Agrega un paciente antes del paciente con el código dado")
       // Tarea
    }

    /**
     * Adiciona un paciente al arreglo de pacientes después
     * del paciente con el código especificado.
     *
     * Si ya existe un paciente con el código igual a pac.codigo
     * se debe genera  una excepción YaExistePaciente
     */
    fun agregarPacienteDespuesDe(cod: Int, pac: Paciente) {
        TODO("Agrega un paciente después del paciente con el código cod")
    }

    /**
     * Elimina el paciente que se encuentra en la posición cero
     * del arreglo.
     */
    private fun eliminarPrimerPaciente() {
        require(numPacientes > 0) // debe haber al menos un paciente
           for (i in 0  until numPacientes - 1){
            pacientes[i] = pacientes[i +1]
        }
        numPacientes -- // Disminuimos el numero de pacientes
    }

    /**
     * Elimina el paciente que se encuentra en última posición
     * del arreglo.
     */
    private fun eliminarUltimoPaciente() {
        require(numPacientes > 0)
        numPacientes --
    }


    /**
     * Elimina el paciente con el código especificado.
     *
     * Si no existe el paciente con el código dado, genera la excepción
     * NoExisteException con el código del paciente
     *
     * @throws NoExisteException
     */
    @Throws(NoExisteException::class)
    fun eliminarPaciente(cod: Int) {

        val pos = obtenerPosicionPaciente(cod)
        if (pos == -1){
            throw NoExisteException(cod)
        }
        when(pos){
            0-> eliminarPrimerPaciente()
            numPacientes - 1 -> eliminarUltimoPaciente()
            // else -> terminar estudiante.
        }
    }

    /**
     * Retorna la cantidad de hombres que hay en el arreglo
     */
    fun cantHombres(): Int {
        var count = 0
        for (i in 0 until numPacientes) {
            if (pacientes[i].sexo == HOMBRE) count++
        }
        return count
    }



    /**
     * Retorna la cantidad de mujeres que hay en el arreglo
     */
    fun cantMujeres(): Int {
        var count = 0
        for (i in 0 until numPacientes){
            if(pacientes[i].sexo== MUJER) count++
        }
        return count
    }

    /**
     * Función que encuentra el paciente que tienen el nombre
     * más largo. Use el método length de los nombre para saber
     * el tamaño del nombre
     */
    fun nombreMasLargo(): Paciente {
        TODO("Obtener el paciente con el nombre mas largo")
    }

    /**
     * Permite obtener y retornar el el porcentaje de pacientes
     * en el arreglo que se encuentran hospitalizados en la
     * clínica con el nombre dado. El valor del porcentaje debe
     * estar entre 0.0 y 100.0
     */

    fun porcentajeClinica(clinica: String): Double {
        var count = 0
        for (i in 0 until numPacientes) {
            if (pacientes[i].clinica == clinica) {
                count++
            }
        }
        return (count.toDouble() / numPacientes.toDouble()) * 100.0
    }
    }






