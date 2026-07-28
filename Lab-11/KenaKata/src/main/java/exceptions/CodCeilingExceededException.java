package exceptions;

public class CodCeilingExceededException extends PaymentDeclinedException{
    public CouponRejectedException(String message){
        super(message);
    }
}
