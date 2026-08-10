package kenakata.payment;
import kenakata.exceptions.CardLimitExceedException;
import kenakata.exceptions.CardLimitExceededException;


public class CardPayment implements PaymentMethod {
    private long remainingLimit;

    public CardPayment(long limit) {
        this.remainingLimit = limit;
    }

    public long remainingLimit() {
        return remainingLimit;
    }

    public void authorise(long amount) throws CardLimitExceedException, kenakata.payment.CardLimitExceededException {
        if(amount>remainingLimit){
            throw new kenakata.payment.CardLimitExceededException("Card limit exceeded.");
        }
    remainingLimit -=amount;
    }
}
