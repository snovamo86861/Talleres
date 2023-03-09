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
 */
class ListaPacientes() {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Arreglo con la información de los pacientes
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
     */
    fun obtenerPosicionPaciente(codigo: Int): Int {
        return -1
    }

    /**
     * Retorna el paciente que se encuentra en la posición
     * especificada del arreglo.
     */
    fun obtenerPaciente(posicion: Int): Paciente {
        require(posicion in 0 until numPacientes)
        TODO("Retornar el paciente en la posición dada")
    }

    /**
     * Permite obtener el paciente con el código dado
     *
     * Si no existe el paciente con ese código, deberá
     * retornarse un null
     */
    fun localizar(cod: Int): Paciente? {
        return null
    }

    /**
     * Adiciona un paciente al principio del arreglo de pacientes
     *
     * Si ya existe un paciente con el código igual a pac.codigo
     * se debe genera  una excepción YaExistePaciente
     */
    fun agregarPacienteAlComienzo(pac: Paciente) {
        TODO("Realizar el método que agrega al principio")
    }

    /**
     * Adiciona un paciente al final del arreglo de pacientes
     *
     * Si ya existe un paciente con el código igual a pac.codigo
     * se debe genera  una excepción YaExistePaciente
     */
    fun agregarPacienteAlFinal(pac: Paciente) {
        TODO("Agregar un paciente al final de la lista")
    }

    /**
     * Adiciona un paciente al arreglo de pacientes antes
     * del paciente con el código especificado.
     *
     * Si ya existe un paciente con el código igual a pac.codigo
     * se debe genera  una excepción YaExistePaciente
     */
    fun agregarPacienteAntesDe(cod: Int, pac: Paciente) {
        TODO("Agrega un paciente antes del paciente con el código dado")
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
        TODO("Eliminar el primer paciente del arreglo")
    }

    /**
     * Elimina el paciente que se encuentra en última posición
     * del arreglo.
     */
    private fun eliminarUltimoPaciente() {
        TODO("Eliminar el ultimo paciente del arreglo.")
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

        TODO("Elimina el paciente que tiene el código dado")
    }

    /**
     * Retorna la cantidad de hombres que hay en el arreglo
     */
    fun cantHombres(): Int {
        return 0
    }

    /**
     * Retorna la cantidad de mujeres que hay en el arreglo
     */
    fun cantMujeres(): Int {
        return 0
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
        return 0.0
    }
}