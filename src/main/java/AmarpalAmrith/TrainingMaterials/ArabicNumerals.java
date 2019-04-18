package AmarpalAmrith.TrainingMaterials;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ArabicNumerals {

    public static void convertFromFile() throws IOException {
        List<String> numeralFiles = Files.readAllLines(Paths.get("exampleNumerals.txt"));
        int total = 0;
        for (String numeral : numeralFiles) {
            int convertedLineToInt = RomanNumerals.convertToInteger(numeral);
            int correctedNumeralLength = ArabicNumerals.convertToRoman(convertedLineToInt).length();
            int differenceInNumerals = numeral.length() - correctedNumeralLength;
            if (convertedLineToInt != -1) {
                total += differenceInNumerals;
            }
        }
        System.out.println(total);
    }

    public static String convertToRoman(int number) {
        StringBuilder romanNumeral = new StringBuilder();

        romanNumeral.append(getThousands(number));
        romanNumeral.append(getHundreds(number));
        romanNumeral.append(getTens(number));
        romanNumeral.append(getUnits(number));

        return romanNumeral.toString();
    }

    private static String getThousands(int number) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count(number, 1000); i++) {
            sb.append("M");
        }
        return sb.toString();
    }
    
    private static String getHundreds(int number) {
        return getNumeral(count(number % 1000,100), "C", "D", "M");
    }
    
    private static String getTens(int number) {
        return getNumeral(count(number % 100,10), "X", "L", "C");
    }
    
    private static String getUnits(int number) {
        return getNumeral(number % 10, "I", "V", "X");
    }
    
    private static int count(int number, int units) {
        return number / units;
    }

    private static String getNumeral(int count, String minor, String mid, String max) {

        StringBuilder sb = new StringBuilder();

        if (count == 1) {
            return minor;
        } else if (count > 0 && count < 4) {
            for (int i = 0; i < count; i++) {
                sb.append(minor);
            }
        } else if (count == 4) {
            sb.append(minor).append(mid);
        } else if (count == 5) {
            sb.append(mid);
        } else if (count > 5 && count < 9) {

            sb.append(mid);
            int overMid = count - 5;

            for (int i = 0; i < overMid; i++) {
                sb.append(minor);
            }

        } else if (count == 9) {
            sb.append(minor).append(max);
        }
        return sb.toString();
    }

}
