package kenakata.exceptions;

public class CardLimitExceedException extends Exception{
    public CardLimitExceedException(String message){
        super(message);
    }
}
