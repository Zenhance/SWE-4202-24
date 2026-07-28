package Exceptions;

public class CouponRejectedException extends CheckoutException{
    public CouponRejectedException(String message)
    {
        super(message);
    }
}
