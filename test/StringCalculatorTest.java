import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(23, calculator.add("20,3"), 0);
    }

    @Test
    public void testSumForStringWithUnknownCountOfNumber()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(35, calculator.add("20,10,5"), 0);
        assertEquals(10, calculator.add("1,1,1,1,6"), 0);
        assertEquals(16, calculator.add("3,5,8,0"), 0);
    }

    @Test
    public void testSumForStringWithNewlineAsDelimiter()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(14, calculator.add("5\n7,2"), 0);
        assertEquals(9, calculator.add("3\n4\n2"), 0);
        assertEquals(20, calculator.add("3,4,2\n6,5"), 0);
    }

    @Test
    public void testSumForStringWhichSupportsDifferentDelimiters()
    {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("//;\n1;2"), 0);
        assertEquals(30, calculator.add("//?1?2?27"), 0);
        assertEquals(6, calculator.add("//,1,2\n3"), 0);
    }

    @Test
    public void testForExceptionWhenNegativeNumbersArePassed()
    {
        StringCalculator calculator = new StringCalculator();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("5,4,-1"));
        assertEquals("negatives not allowed: -1", exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class, () -> calculator.add("5,4,-1, -5"));
        assertEquals("negatives not allowed: -1, -5", exception.getMessage());
    }

}
