public class StringCalculator {
    public static int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        String separator = getSeparator(numbers);

        if(numbers.startsWith("//")){
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        }

        String []numTokens = numbers.split(separator); //splitting token , as delimiter

        if(numTokens.length == 1){
            return Integer.parseInt(numbers);
        }else{
            int sum = 0;
            for(String num : numTokens){
                sum += Integer.parseInt(num);
            }
            return sum;
        }
    }

    public static String getSeparator(String number){
        String separator = "[\n";
        if(number.startsWith("//")){
            separator += number.substring(2,number.indexOf("\n")) +"]";
        }else{
            separator += ",]";
        }
        return separator;
    }
}
