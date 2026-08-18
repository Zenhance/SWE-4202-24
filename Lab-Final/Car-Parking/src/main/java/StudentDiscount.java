public  class StudentDiscount implements DiscountScheme {
    @Override
    public int applyDiscount(int bill) {
        return bill - (50 * bill / 100);
    }
}