package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CaesarShiftCipherTest {

    private CaesarShiftCipher csc;

    @BeforeEach
    public void initialize() {
        this.csc = new CaesarShiftCipher();
    }

    @ParameterizedTest(name="message={0}, shift={1}, result={2}")
    @CsvSource({"abc,1,bcd", "abc,-1,zab"})
    public void testPositiveAndNegativeShifting(String message, int shift, String result) {
        String s = this.csc.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(s, result);
    }

    @ParameterizedTest(name="message={0}, shift={1}, result={2}")
    @CsvSource({"abc d,1,bcd e", "abc d e,1,bcd e f"})
    public void testMessageWithSpaces(String message, int shift, String result) {
        String s = this.csc.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(s, result);
    }

    @ParameterizedTest(name="message={0}, shift={1}")
    @CsvSource({"845,1", "ab*,1", "^&,1"})
    public void testInvalidSymbols(String message, int shift) {
        String s = this.csc.CaesarShiftCipher(message, shift);
        Assertions.assertEquals(s, "invalid");
    }

}
