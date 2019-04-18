package AmarpalAmrith.TrainingMaterials;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Utilities.welcomeMsg("Hi!");
        int inputInteger = 0;
        while (true) {
            String input = Utilities.requestString("Please enter a Roman number to translate to english");
            try {
                inputInteger = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                inputInteger = -1;
            }
            if (inputInteger != -1) {
                System.out.println(ArabicNumerals.convertToRoman(inputInteger));
            } else if (input.equalsIgnoreCase("read file")) {
                ArabicNumerals.convertFromFile();
            } else {
                System.out.println(RomanNumerals.convertToInteger(input));
            }
        }
    }

}

