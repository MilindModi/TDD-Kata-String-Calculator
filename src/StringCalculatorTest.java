import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class StringCalculatorTest {
    @Test
    public void addTest(){
        assertEquals(StringCalculator.add(""),0); //Empty String test case
        assertEquals(StringCalculator.add("19"),19); //single digit string test case
    }
}