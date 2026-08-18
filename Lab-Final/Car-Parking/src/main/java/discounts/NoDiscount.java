package discounts;

public class NoDiscount implements DiscountScheme{

    @Override
    public int apply(int bill) {
        return bill;
    }

}
