package CarParking;

public final  class WeekendDiscount implements DiscountPolicy{
    @Override
    public int apply(int bill){
        return Math.max(0,bill-10);
    }

}
