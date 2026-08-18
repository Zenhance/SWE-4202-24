public  class StudentDiscount implements DiscountScheme {
    @Override
    public int applyDiscount(int bill) {
        return bill - (20 * bill / 100);
    }
}