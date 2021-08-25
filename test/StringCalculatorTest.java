import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest
{
    @Test
    public void testSumForEmptyString()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""), 0);
    }

    @Test
    public void testSumForStringWithSingleNumber()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"), 0);
        assertEquals(0, calculator.add("0"), 0);
    }

    @Test
    public void testSumForStringWithTwoNumbers()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(5, calculator.add("2,3"), 0);
        assertEquals(17, calculator.add("20,-3"), 0);
        assertEquals(-10, calculator.add("-500,490"), 0);
    }

    @Test
    public void testSumForStringWithUnknownCountOfNumber()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(35, calculator.add("20,10,5"), 0);
        assertEquals(10, calculator.add("1,1,1,1,6"), 0);
        assertEquals(0, calculator.add("3,5,-8,0"), 0);
    }

    @Test
    public void testSumForStringWithNewlineAsDelimiter()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(14, calculator.add("5\n7,2"), 0);
        assertEquals(9, calculator.add("3\n4\n2"), 0);
        assertEquals(14, calculator.add("-3,4,2\n6,5"), 0);
    }

}
