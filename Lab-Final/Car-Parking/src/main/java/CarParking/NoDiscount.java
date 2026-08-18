package CarParking;

public final class NoDiscount implements DiscountPolicy{
    @Override
    public int apply(int bill){
        return bill;
    }
}
