import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

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

        //first line as delimiter definition
        assertEquals(StringCalculator.add("//;\n1;2"),3,"string with delimiter(;) should act as separator");

        //first line as delimiter definition
        assertEquals(StringCalculator.add("//?\n2?2?2"),6,"string with delimiter(?) should act as separator");
    }

    public void addNegativeNumberTest(){

        //negative numbers will throw an exception
        try{
            StringCalculator.add("-01,-2,-33");
        }catch(NegativeNumberException ne){
            assertEquals(ne.getMessage(),"Negative Numbers are not allowed: [-01, -2, -33]","Negative numbers are not allowed");
        }

        //negative numbers will throw an exception
        try{
            StringCalculator.add("1,2,-33");
        }catch(NegativeNumberException ne){
            assertEquals(ne.getMessage(),"Negative Numbers are not allowed: [-33]","Negative numbers are not allowed");
        }

        //negative numbers will throw an exception
        try{
            StringCalculator.add("//;\n1;2;-33");
        }catch(NegativeNumberException ne){
            assertEquals(ne.getMessage(),"Negative Numbers are not allowed: [-33]","Negative numbers are not allowed");
        }
    }

    public void addBiggerNumberTest() {
        //bigger than 1000
        assertEquals(StringCalculator.add("1,1001,3"),4,"Number bigger than 1000 should be ignored");

        assertEquals(StringCalculator.add("//;\n1;2;1003"),3,"Number bigger than 1000 should be ignored");
    }

    public void addMultiCharacterDelimiterTest() {
        // Multi character delimiter
        assertEquals(StringCalculator.add("//[***]\n1***2***3"),6,"single Multi character delimiter");

        //multiple multi character delimiter
        assertEquals(StringCalculator.add("//[*][%]\n1*2%3"),6,"Multiple multi character delimiters");

        //multiple character delimiter
        assertEquals(StringCalculator.add("//[*][%][$$$]\n1*2%3$$$5"),11,"Multiple multi character delimiters");

    }
}