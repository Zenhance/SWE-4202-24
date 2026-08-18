public class StudentDiscount implements Discount {
    @Override
    public int apply(int bill) {
        return bill-(20*bill/100) ;
    }
}
