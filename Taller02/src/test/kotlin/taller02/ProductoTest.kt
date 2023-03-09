package taller02




import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
internal class ProductoTest{
    @Test
    fun prueba1() {
        // Pruebas de la clase Producto
        val prod = Producto("aspirina", "drogueria", 1_000.0, 50, 25)

        assertEquals("aspirina", prod.nombre)
        assertEquals("drogueria", prod.tipo)
        assertEquals(1_000.0, prod.valorUnitario)
        assertEquals(25, prod.cantidadMinima)
        assertEquals(50, prod.cantidadBodega)

        assertEquals(0.12, prod.darIVA(), "El IVA del producto no es correcto")
        assertEquals(1120.0, prod.calcularPrecioFinal())

        prod.vender(10)
        // assertEquals(40, prod.cantidadBodega)
        Assertions.assertFalse(prod.puedeAbastecer())

        prod.vender(50)
        assertEquals(0, prod.cantidadBodega)
        Assertions.assertTrue(prod.puedeAbastecer())

        prod.abastecer(60)
        assertEquals(1_000.0, prod.valorUnitario)
        assertEquals(25, prod.cantidadMinima)
        assertEquals(60, prod.cantidadBodega)
        Assertions.assertFalse(prod.puedeAbastecer())
        println("Prueba superada. Clase producto correcto!")
    }

}