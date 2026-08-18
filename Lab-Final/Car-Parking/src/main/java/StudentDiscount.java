public class StudentDiscount implements DiscountScheme {

    @Override
    public int apply(int bill) {
        return bill - (bill * 20 / 100);
    }
}
