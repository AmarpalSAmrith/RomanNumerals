package AmarpalAmrith.TrainingMaterials;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Utilities.welcomeMsg("Hi!");
        while (true) {
            String input = Utilities.requestString("Please enter a Roman number to translate to english");
            int total = convertToInteger(input);
            if (total == -1) {
                System.out.println("Please enter a valid number!");
            } else {
                System.out.println(total);
            }
        }
    }

    public static int convertToInteger(String romanNumeral) {
        List<String> romanNumerals = getRomanNumerals(romanNumeral);

        if (!inDescendingOrder(romanNumerals) ||
                !isAcceptableCombinations(romanNumerals)
                || !isAcceptableDoubleSymbol(romanNumerals)
                || !duplicateDLV(romanNumerals)
        ) {
            return -1;
        }
        return getTotal(romanNumerals);
    }

    private static boolean duplicateDLV(List<String> romanNumerals) {
        int d = 0, l = 0, v = 0;
        for (String romanNumeral : romanNumerals) {
            for (int j = 0; j < romanNumeral.length(); j++) {
                switch (romanNumeral.charAt(j)) {
                    case 'D':
                        d++;
                        break;
                    case 'L':
                        l++;
                        break;
                    case 'V':
                        v++;
                        break;
                }
            }
        }
        return (d + l + v) == 0 || (d == 1 || l == 1 || v == 1);
    }


    private static boolean isAcceptableDoubleSymbol(List<String> romanNumerals) {
        for (String numeral : romanNumerals) {
            if (numeral.length() == 2) {
                if (numeral.charAt(0) == 'I') {
                    return numeral.charAt(1) == 'V' || numeral.charAt(1) == 'X';
                }
                if (numeral.charAt(0) == 'X') {
                    return numeral.charAt(1) == 'L' || numeral.charAt(1) == 'C';
                }
                if (numeral.charAt(0) == 'C') {
                    return numeral.charAt(1) == 'D' || numeral.charAt(1) == 'M';
                }
            }
        }
        return true;
    }

    private static boolean isAcceptableCombinations(List<String> romanNumerals) {
        if (isRemainingGreaterThan(romanNumerals, 1000)) return false;
        if (isRemainingGreaterThan(romanNumerals, 100)) return false;
        if (isRemainingGreaterThan(romanNumerals, 10)) return false;
        return true;
    }

    private static boolean isRemainingGreaterThan(List<String> list, int maxValue) {
        List<Integer> numeralsConverted = list.stream().map(Main::numeralValue).collect(Collectors.toList());
        int total = 0;
        for (int i = 0; i < numeralsConverted.size(); i++) {
            if (numeralsConverted.get(i) < maxValue) {
                for (int j = i; j < numeralsConverted.size(); j++) {
                    total += numeralsConverted.get(j);
                }
                return total >= maxValue;
            }
        }
        return false;
    }

    private static List<String> getRomanNumerals(String romanNumeral) {
        List<String> numerals = new ArrayList<>();
        for (int i = 0; i < romanNumeral.length(); i++) {
            if (i < romanNumeral.length() - 1) {
                if (numeralValue(romanNumeral.substring(i, i + 1)) < numeralValue(romanNumeral.substring(i + 1, i + 2))) {
                    numerals.add(romanNumeral.substring(i, i + 2));
                    i++;
                } else {
                    numerals.add(romanNumeral.substring(i, i + 1));
                }
            } else {
                numerals.add(romanNumeral.substring(i, i + 1));
            }
        }
        return numerals;
    }

    private static boolean inDescendingOrder(List<String> list) {
        List<Integer> numeralsConverted = list.stream().map(Main::numeralValue).collect(Collectors.toList());
        for (int i = 0; i < numeralsConverted.size() - 1; i++) {
            if (numeralsConverted.get(i) < numeralsConverted.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static int getTotal(List<String> numerals) {
        return numerals.stream().map(Main::numeralValue).reduce(0, (a, b) -> a + b);
    }

    private static int numeralValue(String numeral) {
        String s = numeral.toLowerCase();
        int total = 0;
        if (numeral.length() > 1) {
            total -= getNumeral(s.substring(0, 1));
            total += getNumeral(s.substring(1, 2));
            return total;
        } else {
            return getNumeral(s);
        }
    }

    private static int getNumeral(String s) {
        switch (s) {
            case "i":
                return 1;
            case "v":
                return 5;
            case "x":
                return 10;
            case "l":
                return 50;
            case "c":
                return 100;
            case "d":
                return 500;
            case "m":
                return 1000;
            default:
                return 0;
        }
    }
}
