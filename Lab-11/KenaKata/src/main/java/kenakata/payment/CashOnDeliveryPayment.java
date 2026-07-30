package kenakata.payment;
import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment implements PaymentMethod{
    private static final int LIMIT=15000;

    public void authorise(int amount)throws CodCeilingExceededException{
        if(amount>LIMIT){
            throw new CodCeilingExceededException();
        }
    }
}
