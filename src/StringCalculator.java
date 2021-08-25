public class StringCalculator
{
    public int add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        String[] splitNumbers = numbers.split(",");
        int sum = 0;
        for(String s : splitNumbers)
        {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
