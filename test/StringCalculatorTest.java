import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest
{
    @Test
    public void testSumForEmptyString()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""), 0);
        assertEquals(0, calculator.add(" "), 0);
    }

    @Test
    public void testSumForSingleNumber()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"), 0);
        assertEquals(0, calculator.add("0"), 0);
    }

}
