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
        // "//[***]\n1***2***3"
        // "//;\n1;2"
        String specialDelimiter = String.valueOf(numbers.charAt(2));
        if(specialDelimiter.equals("["))
        {
            specialDelimiter = numbers.charAt(3) + "\\[" + "\\]";
        }
        String regex = "[,\\n" + specialDelimiter + "/]";
        ArrayList<String> finalList = new ArrayList<>(Arrays.asList(numbers.split(regex)));
        finalList.removeIf(String::isEmpty);
        return finalList.toArray(new String[0]);
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
