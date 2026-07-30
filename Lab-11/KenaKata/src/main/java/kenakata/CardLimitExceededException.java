package kenakata;

public class CardLimitExceededException extends PaymentDeclinedException {
    CardLimitExceededException(String message){
        super(message);
    }
}
