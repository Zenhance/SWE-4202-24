package kenakata.payment;

public class CashOnDeliveryPayment implements PaymentMethod{
    @Override
    public int remainingLimit() {
        return 0;
    }

    @Override
    public void authorise(int i) {

    }
}
