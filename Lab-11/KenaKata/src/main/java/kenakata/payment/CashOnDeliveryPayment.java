package kenakata.payment;
import kenakata.exceptions.CodCeilingExceededException;
import kenakata.exceptions.PaymentDeclinedException;

public class CashOnDeliveryPayment implements PaymentMethod{
    private static final long COD_CEILING = 15000;//max threshold 15,000 BDT per cash on delivery
    @Override
    public void authorise(long amount) throws PaymentDeclinedException{
        if(amount >COD_CEILING){
            throw new CodCeilingExceededException("COD ceiling exceeded");
        }
    }
}
