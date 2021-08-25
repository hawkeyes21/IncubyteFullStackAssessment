import java.util.Arrays;

public class StringCalculator
{
    public int add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        int sum = 0;
        String regex = "[,\n]";
        if(numbers.startsWith("//"))
        {
            String customDelimiter = String.valueOf(numbers.charAt(2));
            regex = "[,\n/" + customDelimiter + "]";
        }
        String[] splitNumbers = numbers.split(regex);
        System.out.println(Arrays.toString(splitNumbers));
        for(String s : splitNumbers)
        {
            if(!s.isEmpty())
            {
                sum += Integer.parseInt(s);
            }
        }
        return sum;
    }
}
