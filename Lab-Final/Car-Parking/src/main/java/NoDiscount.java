public class NoDiscount implements Discount {
    @Override
    public int apply(int bill) {
        return bill;
    }
}
