import kotlin.test.Test
import kotlin.test.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {

    @ParameterizedTest
    @CsvSource(
        "100, 5.0, true, 105",
        "100, 5.0, false, 100",
        "100, -10.0, true, 90",
        "100, -200.0, true, 0"
    )
    fun markupCases(product: Int, discount: Double, enabled: Boolean, expected: Int) {
        assertEquals(expected, applyMarkup(product, discount, enabled))
    }
}