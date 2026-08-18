public class WeekendDiscount implements Discount {
    @Override
    public int apply(int bill) {
        return Math.max(0,bill-10);
    }
}
