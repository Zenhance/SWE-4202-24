package kenakata.order;

public class CardPayment extends MobileWalletPayment {
    public CardPayment(int i) {
        super();
    }

    public int remainingLimit() {
        return 0;
    }
}
