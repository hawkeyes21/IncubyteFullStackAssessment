import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return getIntegerSum(numbers);
    }

    private int getIntegerSum(String numbers) {
        String[] splitNumbers = splitNumbersIntoStringArray(numbers);
        int sum = 0;
        for (String s : splitNumbers) {
            int currentNumberIntValue = Integer.parseInt(s);
            if (numberIsNegative(currentNumberIntValue)) {
                throwExceptionBecauseNegativeNumberWasFound(splitNumbers);
            }
            if (numberIsLessThanEqualToThousand(currentNumberIntValue)) {
                sum += Integer.parseInt(s);
            }
        }
        return sum;
    }

    private String[] splitNumbersIntoStringArray(String numbers) {
        if (stringContainsCustomDelimiters(numbers)) {
            return splitNumbersUsingCustomDelimiter(numbers);
        }
        return splitNumbersUsingDefaultDelimiter(numbers);
    }

    private String[] splitNumbersUsingDefaultDelimiter(String numbers) {
        String regex = "[,\n]";
        return numbers.split(regex);
    }

    private String[] splitNumbersUsingCustomDelimiter(String numbers) {
        String regex;
        if (stringHasMultipleCustomDelimiters(numbers)) {
            String customDelimiters = getAllDelimitersDefinedByUser(numbers);
            regex = customDelimiters + appendAngularBrackets();
        } else {
            regex = getSingleCustomDelimiterDefinedByUser(numbers);
        }
        regex = "[//,\n" + regex + "]";
        return stringArrayWhichContainsOnlyNumbers(numbers, regex);
    }

    private String getAllDelimitersDefinedByUser(String numbers) {
        String[] tempSplit = numbers.substring(2).split("\\[");
        StringBuilder delimiters = new StringBuilder();
        for (String s : tempSplit) {
            if (!s.isEmpty()) {
                delimiters.append(s.charAt(0));
            }
        }
        return delimiters.toString();
    }

    private String[] stringArrayWhichContainsOnlyNumbers(String numbers, String regex) {
        ArrayList<String> finalList = new ArrayList<>(Arrays.asList(numbers.split(regex)));
        finalList.removeIf(String::isEmpty);
        return finalList.toArray(new String[0]);
    }

    private void throwExceptionBecauseNegativeNumberWasFound(String[] splitNumbers) {
        String negativeNumbers = getNegativeNumbersFromSplitNumbers(splitNumbers);
        throw new IllegalArgumentException("negatives not allowed: " + negativeNumbers);
    }

    private String getNegativeNumbersFromSplitNumbers(String[] splitNumbers) {
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        for (String s : splitNumbers) {
            if (Integer.parseInt(s) < 0) {
                negativeNumbers.add(Integer.parseInt(s));
            }
        }
        return negativeNumbers.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    private boolean stringContainsCustomDelimiters(String numbers) { return numbers.startsWith("//"); }

    private boolean numberIsNegative(int currentNumberIntValue) {
        return currentNumberIntValue < 0;
    }

    private boolean numberIsLessThanEqualToThousand(int currentNumberIntValue) {
        return currentNumberIntValue <= 1000;
    }

    private boolean stringHasMultipleCustomDelimiters(String numbers) { return numbers.contains("[") && numbers.contains("]"); }

    private String getSingleCustomDelimiterDefinedByUser(String numbers) { return numbers.charAt(2) + "" ; }

    private String appendAngularBrackets() { return "\\[" + "\\]"; }
}
