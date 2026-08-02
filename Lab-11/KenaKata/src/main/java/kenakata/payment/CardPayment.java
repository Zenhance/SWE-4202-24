package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.CheckoutException;

public class CardPayment extends PaymentMethod{

    int limit;
    int remained = limit;

    public CardPayment(int w) {

        super(w);
        this.limit = w;
        this.remained = w;

    }

    public CardPayment() throws CheckoutException {
        throw new CheckoutException("Amount field is empty");
    }
    @Override
    public void authorise(int i) throws Exception{
        if(i > remainingLimit())
            throw new CardLimitExceededException("Limit exceeded");
        remained -= i;
    }
    public int remainingLimit() {
        return remained;
    }


}
