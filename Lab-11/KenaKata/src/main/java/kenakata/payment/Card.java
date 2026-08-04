package kenakata.payment;
import kenakata.exceptions.CardLimitExceededException;
public final class Card implements PaymentMethod {

    private long remainingLimit;

    public Card(long limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit must not be negative");
        }
        this.remainingLimit = limit;
    }

    @Override
    public void authorise(long amount) throws CardLimitExceededException {
        if (amount > remainingLimit) {
            throw new CardLimitExceededException(
                    "amount " + amount + " exceeds remaining limit " + remainingLimit);
        }
        remainingLimit -= amount;
    }

    public long remainingLimit() {
        return remainingLimit;
    }
}
