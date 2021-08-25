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

}
