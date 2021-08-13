public class StringCalculator {
    public static int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        String []numTokens = numbers.split(","); //splitting token , as delimiter
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
}
