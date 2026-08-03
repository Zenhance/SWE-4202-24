package kenakata.payment;
import kenakata.exceptions.CardLimitExceededException;

public final class CardPayment implements PaymentMethod{
    private long remainingLimit;
    public CardPayment(long limit){
        if(limit<0){
            throw new IllegalArgumentException("Card limit cannot be negative");
        }
        this.remainingLimit= limit;
    }
}
