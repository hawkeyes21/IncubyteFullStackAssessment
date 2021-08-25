public class StringCalculator
{
    public int add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        int sum = 0;
        for(String s : numbers.split("[,\n]"))
        {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
