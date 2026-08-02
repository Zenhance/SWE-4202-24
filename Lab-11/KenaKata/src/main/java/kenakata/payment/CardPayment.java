package kenakata.payment;

public class CardPayment extends PaymentMethod{
    private int amount;

    public CardPayment(int amount) {
        this.amount = amount;
    }

    public void authorise(int i) {
    }

    public int remainingLimit() {
        return 0;
    }
}
