package CarParking;

public final  class StudentDiscount implements DiscountPolicy{
    @Override
    public int apply(int bill){
        return bill-(20*bill/100);
    }

}
