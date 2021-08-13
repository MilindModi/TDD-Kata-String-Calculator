import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class StringCalculatorTest {
    @Test
    public void addTest(){
        assertEquals(StringCalculator.add(""),0); //Empty String test case
    }
}