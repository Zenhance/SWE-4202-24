public class StudentDiscount implements Discount {

    @Override
    public int apply(int bill) {
        return bill - (bill * 20) / 100;
    }
}
