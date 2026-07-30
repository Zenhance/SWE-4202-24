package kenakata.exceptions;

public class CardLimitExceededException extends PaymentDeclinedException{
    public CardLimitExceededException(){
        super("Card Limit exceeded");
    }
}
