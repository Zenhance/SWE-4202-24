public class WeekendDiscount implements Discount {

    @Override
    public int apply(int bill) {
        int reduced = bill - 10;
        return Math.max(reduced, 0);
    }
}
