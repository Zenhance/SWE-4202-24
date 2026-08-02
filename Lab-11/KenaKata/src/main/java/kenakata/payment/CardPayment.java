package kenakata.payment;

public class CardPayment implements PaymentMethod{
    public CardPayment(int i) {
        super();
    }

    @Override
    public int remainingLimit() {
        return 0;
    }

    @Override
    public void authorise(int i) {

    }
}
