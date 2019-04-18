import AmarpalAmrith.TrainingMaterials.ArabicNumerals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ArabicNumeralsTest {

    @Test
    public void testThousands() {

        // Arrange
        int number = 2000;

        // Act
        String result = ArabicNumerals.convertToRoman(number);

        // Assert
        assertEquals("MM", result);
    }

    @Test
    public void testHundreds() {

        // Arrange
        int number = 2100;

        // Act
        String result = ArabicNumerals.convertToRoman(number);

        // Assert
        assertEquals("MMC", result);
    }

    @Test
    public void testTens() {

        // Arrange
        int number = 2110;

        // Act
        String result = ArabicNumerals.convertToRoman(number);

        // Assert
        assertEquals("MMCX", result);
    }

    @Test
    public void testUnits() {

        // Arrange
        int number = 2111;

        // Act
        String result = ArabicNumerals.convertToRoman(number);

        // Assert
        assertEquals("MMCXI", result);
    }

    @Test
    public void testNumber() {

        // Arrange
        int number = 2019;

        // Act
        String result = ArabicNumerals.convertToRoman(number);

        // Assert
        assertEquals("MMXIX", result);
    }
}