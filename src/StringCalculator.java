import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        String separator = getSeparator(numbers);
        ArrayList<String> negativeNumbers = new ArrayList<String>();
        if(numbers.startsWith("//")){
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        }

        String []numTokens = numbers.split(separator); //splitting token , as delimiter

        if(numTokens.length == 1){
            return Integer.parseInt(numbers);
        }else{
            int sum = 0;
            for(String num : numTokens){
                int n =  Integer.parseInt(num);
                if(n < 0){
                    negativeNumbers.add(num);
                }else if(n <= 1000){
                    sum += n;
                }
            }
            if(negativeNumbers.isEmpty()){
                return sum;
            }
                throw new NegativeNumberException("Negative Numbers are not allowed: "+negativeNumbers);
        }
    }

    public static String getSeparator(String number){
        String separator = "\n";
        String extraSeparator = "|,";
        if(number.startsWith("//")){

            String tmpDelimiter = number.substring(2,number.indexOf("\n"));

            if(tmpDelimiter.startsWith("[") && tmpDelimiter.endsWith("]")){ // for the case of custom delimiter

                Pattern pattern = Pattern.compile("\\[(.*?)\\]");
                Matcher match = pattern.matcher(tmpDelimiter);
                while(match.find())
                    extraSeparator +=  "|\\Q" + match.group(1)  + "\\E";
            }else{
                extraSeparator += "|\\Q" + tmpDelimiter +"\\E";
            }
        }
        return  separator + extraSeparator;
    }
}
