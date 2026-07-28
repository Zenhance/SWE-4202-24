package exceptions;

public class CardLimitExceededException extends PaymentDeclinedException{
    public CouponRejectedException(String message){
        super(message);
    }
}
