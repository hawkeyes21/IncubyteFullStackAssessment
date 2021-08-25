public class StringCalculator
{
    public int add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        if(numbers.contains(","))
        {
            String[] splitNumbers = numbers.split(",");
            return Integer.parseInt(splitNumbers[0]) + Integer.parseInt(splitNumbers[1]);
        }
        return Integer.parseInt(numbers);
    }
}
