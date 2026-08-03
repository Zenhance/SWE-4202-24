package kenakata.payment;

public class CardPayment implements PaymentMethod{
    private int limit;

    public CardPayment(int limit) {
        if (limit <= 0)
            throw new IllegalArgumentException("Card limit cannot be negative or zero");
        this.limit = limit;
    }

    @Override
    public void authorise(int amount) {

    }

    public int remainingLimit() {
        return 0;
    }
}
