public class WeekendDiscount implements DiscountScheme {
    @Override
    public int applyDiscount(int bill) {
        return Math.max(0, bill - 10);
    }
}