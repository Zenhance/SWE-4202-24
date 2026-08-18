public final class WeekendDiscount implements DiscountScheme {

    @Override
    public int apply(int bill) {
        return Math.max(0, bill - 10);
    }
}