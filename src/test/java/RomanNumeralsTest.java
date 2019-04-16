import AmarpalAmrith.TrainingMaterials.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class RomanNumeralsTest {

    @Test
    public void testSimpleRomanNumeral() {

        // Arrange
        String romanNumeral = "I";

        // Act
        int result = Main.convertToInteger(romanNumeral);

        // Assert
        assertEquals(1, result);
    }

    @Test
    public void testAllSymbols() {
        // Arrange
        String romanNumeral = "MDCLXVI";

        // Act
        int result = Main.convertToInteger(romanNumeral);

        // Assert
        assertEquals(1666, result);
    }

    @Test
    public void testSymbolsArrangedInDescendingOrder() {
        // Arrange
        String romanNumeral = "MXCD";

        // Act
        int result = Main.convertToInteger(romanNumeral);

        // Assert
        assertEquals(-1,result);
    }

    @Test
    public void testSubtractiveProperty() {

        // Arrange
        String romanNumeral = "MCMXCIX";

        // Act
        int result = Main.convertToInteger(romanNumeral);

        // Assert
        assertEquals(1999,result);
    }

    @Test
    public void testTwoSubtractionsProperty() {
        // Act
        String romanNumeral = "IIX";

        //Act
        int result = Main.convertToInteger(romanNumeral);

        //Assert
        assertEquals(-1, result);
    }

    @Test
    public void testSmallerCombinationsToMCX() {
        // Arrange
        String romanNumeral = "LXXXXX";

        // Act
        int result = Main.convertToInteger(romanNumeral);

        // Assert
        assertEquals(-1, result);
    }

    @Test
    public void testSmallerCombinationsCanMakeDLV() {
        // Arrange
        String romanNumeral = "XXXXXX";

        // Act
        int result = Main.convertToInteger(romanNumeral);

        // Assert
        assertEquals(60, result);
    }

    @Test
    public void testICanOnlyComeBeforeVX() {
        //Arrange
        String romanNumeral = "IC";

        // Act
        int result = Main.convertToInteger(romanNumeral);

        // Assert
        assertEquals(-1, result);

    }

    @Test
    public void testXCanOnlyComeBeforeLC() {
        //Arrange
        String romanNumeral = "XM";

        // Act
        int result = Main.convertToInteger(romanNumeral);

        // Assert
        assertEquals(-1, result);

    }

    @Test
    public void testCCanOnlyComeBeforeDM() {
        // TODO: not possible to have a 2 letter combo that is not CD or CM which are both valid
        //Arrange
        String romanNumeral = "CL";

        // Act
        int result = Main.convertToInteger(romanNumeral);

        // Assert
        assertEquals(-1, result);

    }

    @Test
    public void testDLVOnlyAppearOnce() {
        //Arrange
        String romanNumeral = "VIV";

        //Act
        int result = Main.convertToInteger(romanNumeral);

        // Assert
        assertEquals(-1,result);
    }

}
