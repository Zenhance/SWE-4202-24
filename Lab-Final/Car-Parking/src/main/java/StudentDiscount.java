public final class StudentDiscount implements DiscountScheme {

    @Override
    public int apply(int bill) {
        return bill - (20 * bill / 100);
    }
}