package CarParking;

public abstract class AbstractVehicle implements Vehicle {
    private final String plate;
    private final DiscountPolicy discountPolicy;
    protected AbstractVehicle(
            String plate,
            DiscountPolicy discountPolicy
    )
    {
        this.plate=plate;
        this.discountPolicy=discountPolicy;
    }
    @Override
    public String plate(){
        return plate;
    }
    @Override
    public DiscountPolicy discountPolicy(){
        return discountPolicy;
    }
}
