import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class StringCalculatorTest {
    @Test
    public void addTest(){
        //Empty String test case
        assertEquals(StringCalculator.add(""),0,"Empty string testcase failure");

        //single digit string test case
        assertEquals(StringCalculator.add("19"),19,"Single digit testcase failure");

        //coma(,) separated digit String test case
        assertEquals(StringCalculator.add("1,2"),3,"two digit coma separated testcase failure");

        //coma(,) separated digit String test case
        assertEquals(StringCalculator.add("1,2,3"),6,"coma(,) separated digit String testcase failure");

        assertEquals(StringCalculator.add("2,2,5,5"),14,"coma separated digits testcase failure");
    }
}