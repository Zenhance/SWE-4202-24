package kenakata.payment;

public class CardPayment implements PaymentMethod {
    private long remainingLimit;

    public CardPayment(long limit) {
        this.remainingLimit = limit;
    }

    public long remainingLimit() {
        return remainingLimit;
    }

    public void authorise(long amount){
        if(amount>remainingLimit){
        }
    remainingLimit -=amount;
    }

    @Override
    public void pay() {

    }
}
