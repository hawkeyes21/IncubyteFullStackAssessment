import java.util.ArrayList;
import java.util.Arrays;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] splitNumbers = splitNumbersIntoStringArray(numbers);
        return getIntegerSumFromSplitNumbers(splitNumbers);
    }

    private String[] splitNumbersIntoStringArray(String numbers) {
        if (numbers.startsWith("//")) {
            return splitNumbersUsingSpecialDelimiter(numbers);
        }
        return splitNumbersUsingDefaultDelimiter(numbers);
    }

    private String[] splitNumbersUsingDefaultDelimiter(String numbers) {
        String regex = "[,\n]";
        return numbers.split(regex);
    }

    private String[] splitNumbersUsingSpecialDelimiter(String numbers) {
        String delimiter = String.valueOf(numbers.charAt(2));
        if(numbers.contains("["))
        {
            String multipleDelimiters = getAllDelimitersDefinedByUser(numbers);
            //noinspection RegExpRedundantEscape
            delimiter = multipleDelimiters + "\\[" + "\\]";
        }
        String regex = "[,\n" + delimiter + "/]";
        ArrayList<String> finalList = new ArrayList<>(Arrays.asList(numbers.split(regex)));
        finalList.removeIf(String::isEmpty);
        return finalList.toArray(new String[0]);
    }

    private String getAllDelimitersDefinedByUser(String numbers)
    {
        String[] tempSplit = numbers.substring(2).split("\\[");
        StringBuilder delimiters = new StringBuilder();
        for(String s : tempSplit)
        {
            if(!s.isEmpty())
            {
                delimiters.append(s.charAt(0));
            }
        }
        return delimiters.toString();
    }

    private int getIntegerSumFromSplitNumbers(String[] splitNumbers) {
        int sum = 0;
        for (String s : splitNumbers) {
            int currentNumberIntValue = Integer.parseInt(s);
            if (numberIsNegative(currentNumberIntValue)) {
                throwExceptionBecauseNegativeNumberWasFound(splitNumbers);
            }
            if(numberIsLessThanEqualToThousand(currentNumberIntValue)) {
                sum += Integer.parseInt(s);
            }
        }
        return sum;
    }

    private boolean numberIsLessThanEqualToThousand(int currentNumberIntValue) {
        return currentNumberIntValue <= 1000;
    }

    private boolean numberIsNegative(int currentNumberIntValue) {
        return currentNumberIntValue < 0;
    }

    private void throwExceptionBecauseNegativeNumberWasFound(String[] splitNumbers)
    {
        ArrayList<Integer> negativeNumbers = generateNegativeNumbersFromSplitNumbers(splitNumbers);
        throw new IllegalArgumentException("negatives not allowed: " + negativeNumbers);
    }

    private ArrayList<Integer> generateNegativeNumbersFromSplitNumbers(String[] splitNumbers) {
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        for (String s : splitNumbers) {
            if (Integer.parseInt(s) < 0) {
                negativeNumbers.add(Integer.parseInt(s));
            }
        }
        return negativeNumbers;
    }
}
