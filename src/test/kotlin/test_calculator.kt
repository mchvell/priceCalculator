import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorTest {

    @Test
    fun markupAppliesCorrectly() {
        val result = applyMarkup(100, 5.0, true)
        assertEquals(105, result)
    }
}