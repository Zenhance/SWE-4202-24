public class WeekendDiscount implements Discount {
    @Override
    public int apply(int initialBill) {
        return Math.max(0, initialBill-10);
    }
}
