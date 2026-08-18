public class NoDiscount implements Discount {
    @Override
    public int apply(int initialBill) {
        return initialBill;
    }
}
