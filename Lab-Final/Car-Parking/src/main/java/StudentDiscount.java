public class StudentDiscount implements Discount {
    @Override
    public int apply(int initialBill) {
        int discounted = initialBill - (20*initialBill/100);
        return Math.max(0, discounted);
    }
}
