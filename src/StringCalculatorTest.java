import org.testng.annotations.Test;
import static org.testng.Assert.*;
@Test
public class StringCalculatorTest {

    public void addStringDigitsTest(){
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

    public void addCustomDelimiterTest(){
        //new line as delimiter
        assertEquals(StringCalculator.add("1\n2,3"),6,"digit string with //\n");

        //new line as delimiter
        assertEquals(StringCalculator.add("1\n2,3,4"),10,"digit string with /\n");
    }
}