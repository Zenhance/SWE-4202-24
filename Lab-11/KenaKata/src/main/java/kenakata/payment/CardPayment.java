package kenakata.payment;
import kenakata.exception.CardLimitExceededException;
import kenakata.util.Validate;

public class CardPayment implements PaymentMethod {

    private final String cardNumber;
    private long remainingLimit;

    public CardPayment(long remainingLimit) {
        this("CARD", remainingLimit);
    }

    public CardPayment(
            String cardNumber,
            long remainingLimit
    ){
        this.cardNumber = Validate.notBlank(cardNumber, "Card number"
        );

        this.remainingLimit = Validate.nonNegative(
                remainingLimit,
                "Card remaining limit"
        );
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getNumber() {
        return cardNumber;
    }

    public long getRemainingLimit() {
        return remainingLimit;
    }

    public long getLimit() {
        return remainingLimit;
    }

    public long remainingLimit() {
        return remainingLimit;
    }


    @Override
    public void authorize(long amount)
            throws CardLimitExceededException {

        Validate.nonNegative(
                amount,
                "Payment amount"
        );

        if (amount > remainingLimit) {
            throw new CardLimitExceededException(
                    "Card limit exceeded. "
                            + "Required: "
                            + amount
                            + " Taka, remaining limit: "
                            + remainingLimit
                            + " Taka."
            );
        }

        remainingLimit = Math.subtractExact(
                remainingLimit,
                amount
        );
    }


    public void increaseLimit(long amount) {
        Validate.positive(
                amount,
                "Limit increase amount"
        );

        remainingLimit = Math.addExact(
                remainingLimit,
                amount
        );
    }

    @Override
    public String toString() {
        return "CardPayment{number='"
                + cardNumber
                + "', remainingLimit="
                + remainingLimit
                + "}";
    }
}

