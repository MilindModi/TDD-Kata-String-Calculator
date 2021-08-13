import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author : Milind Modi
 */
public class StringCalculator {

    /**
     * @param numbers string numbers separated by delimiter
     * @return addition of string numbers
     */
    public static int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }

        // get delimiter for string
        String separator = getSeparator(numbers);
        ArrayList<String> negativeNumbers = new ArrayList<String>();

        // if first line is custom delimiter
        if(numbers.startsWith("//")){
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        }

        String []numTokens = numbers.split(separator);  // splitting token , as delimiter

        if(numTokens.length == 1){
            return Integer.parseInt(numbers);
        } else {
            int sum = 0;
            for(String num : numTokens){
                int n =  Integer.parseInt(num);
                if(n < 0){
                    negativeNumbers.add(num);
                } else if(n <= 1000){  // ignore bigger than 1000
                    sum += n;
                }
            }
            if(negativeNumbers.isEmpty())  // if no negative numbers found
                return sum;

            throw new NegativeNumberException("Negative Numbers are not allowed: "+negativeNumbers);
        }
    }

    public static String getSeparator(String number){
        String separator = "\n";
        String extraSeparator = "|,";
        if(number.startsWith("//")){

            // peek custom delimiter till \n
            String tmpDelimiter = number.substring(2,number.indexOf("\n"));

            // for the case of custom delimiter
            if(tmpDelimiter.startsWith("[") && tmpDelimiter.endsWith("]")){

                // extracting delimiters b/w [ ]
                Pattern pattern = Pattern.compile("\\[(.*?)\\]");
                Matcher match = pattern.matcher(tmpDelimiter);
                while(match.find())
                    extraSeparator +=  "|\\Q" + match.group(1)  + "\\E"; //  Escape sq. for special chars.
            } else
                extraSeparator += "|\\Q" + tmpDelimiter +"\\E";
        }
        return  separator + extraSeparator;
    }
}
