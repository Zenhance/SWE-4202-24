package kenakata.payment;
import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.CodCeilingExceededException;
public class CashOnDeliveryPayment implements PaymentMethod{
    private static final long CEILING=15000;

    @Override
    public void authorise(long amount) throws  CodCeilingExceededException{
        if(amount>CEILING){
            throw new CodCeilingExceededException("COD ceiling exceeded");
        }

    }
}
