package kenakata.payment;

public class Card extends CardPayment {

    public Card(long remainingLimit) {
        super(remainingLimit);
    }

    public Card(
            String cardNumber,
            long remainingLimit
    ) {
        super(
                cardNumber,
                remainingLimit
        );
    }
}