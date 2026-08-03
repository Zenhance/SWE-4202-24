package kenakata.payment;
import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.PaymentDeclinedException;
public class CardPayment implements PaymentMethod {
    private long limit;
    public CardPayment(long limit){
        this.limit = limit;
    }
    public long remainingLimit(){
        return limit;
    }
    @Override
    public void authorise(long amount) throws PaymentDeclinedException{
        if (amount > limit){
            throw new CardLimitExceededException("Card limit exceeded");
        }
        limit -= amount;
    }
}
