package kenakata.payment;

public class CardPayment implements PaymentMethod {
    private long limit;

    public CardPayment(long limit) {
        this.limit = limit;
    }


    @Override
    public void authorise(int amount) {

    }

    public long limit() {
        return limit;
    }
}
