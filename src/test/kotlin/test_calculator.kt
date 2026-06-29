import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals
import kotlin.test.Test
import kotlin.test.assertContains


class CalculatorTest {


    @ParameterizedTest
    @CsvSource(
        "100, 5.0, true, 105",
        "100, 5.0, false, 100",
        "100, -10.0, true, 90",
        "100, -200.0, true, 0"
    )
    fun markupCases(product: Int, discount: Double, enabled: Boolean, expected: Int) {
        assertEquals(expected, applyMarkup(product, discount,
            enabled))
    }


    @Test
    fun calculateTotalAndLogistics() {
        val result = calculateTotal(1000, 200)
        assertEquals(1200, result)
    }


    @Test
    fun calculateTotalWithZeroLogistics() {
        val result = calculateTotal(1000, 0)
        assertEquals(1000, result)
    }

    @Test
    fun calculateTotalWithZeroProduct() {
        val result = calculateTotal(0, 200)
        assertEquals(200, result)
    }

    @Test
    fun calculateMarkup(){
        val result = applyMarkup(100, 5.00, true)
        assertEquals(105, result)
    }

    @Test
    fun calculatePriceWithoutMarkup(){
        val result = applyMarkup(100, 5.00, false)
        assertEquals(100, result)
    }

    @Test
    fun calculatePriceWithNegativeMarkup(){
        val result = applyMarkup(100, -5.00, true)
        assertEquals(95, result)
    }

    @Test
    fun calculatePriceWithImpossibleMarkup(){
        val result = applyMarkup(100, -150.00, true)
        assertEquals(0, result)
    }

    @Test
    fun validateFinalPriceWithLogistics(){
        val result = applyFinalPrice(1000, 100, true)
        assertContains(result, "1100")
    }


    @Test
    fun validateFinalPriceWithoutLogistics(){
        val result = applyFinalPrice(1000, 250, false)
        assertContains(result, "доставка")
        assertContains(result, "250")
    }
}
