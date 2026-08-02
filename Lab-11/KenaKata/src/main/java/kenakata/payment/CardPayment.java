package kenakata.payment;

public class CardPayment extends PaymentMethod{
    private int limit;

    public CardPayment(int limit) {
        this.limit = limit;
    }
}
