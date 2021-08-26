import java.util.ArrayList;

public class StringCalculator
{
    public int add(String numbers)
    {
        if(numbers.isEmpty())
        {
            return 0;
        }
        String[] splitNumbers = splitNumbers(numbers);
        return getIntegerSumFromSplitNumbers(splitNumbers);
    }

    private int getIntegerSumFromSplitNumbers(String[] splitNumbers)
    {
        int sum = 0;
        for(String s : splitNumbers)
        {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    private String[] splitNumbers(String numbers)
    {
        if(numbers.startsWith("//"))
        {
            return splitNumbersUsingSpecialDelimiter(numbers);
        }
        return splitNumbersUsingDefaultDelimiter(numbers);
    }

    private String[] splitNumbersUsingDefaultDelimiter(String numbers)
    {
        String regex = "[,\n]";
        return numbers.split(regex);
    }

    private String[] splitNumbersUsingSpecialDelimiter(String numbers)
    {
        String specialDelimiter = String.valueOf(numbers.charAt(2));
        String regex = "[,\n" + specialDelimiter + "/]";
        String[] splitNumbers = numbers.split(regex);
        ArrayList<String> finalList = new ArrayList<>();
        for(String s : splitNumbers)
        {
            if(!s.isEmpty())
            {
                finalList.add(s);
            }
        }
        return finalList.toArray(new String[0]);
    }
}
