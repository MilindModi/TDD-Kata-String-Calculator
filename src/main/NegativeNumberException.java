package main;

public class NegativeNumberException extends RuntimeException{
    NegativeNumberException(String errorMessage){
        super(errorMessage);
    }
}
